package eu.interedition.fragmentContext.ws;

import java.io.InputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import eu.interedition.fragmentContext.text.TextConstraint;
import eu.interedition.fragmentContext.text.TextContext;
import eu.interedition.fragmentContext.text.TextContext.HashType;
import eu.interedition.fragmentContext.text.TextPrimary;
import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifier;
import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifierFactory;


public class ConstraintFactory extends ServerResource{
	
	@Post
	public String createConstraint(String args) throws Exception {
		
		JSONObject jsonArgs = new JSONObject(args);
		
		URI targetURI = new URI(jsonArgs.getString("uri"));
		if (targetURI.getFragment() == null) { 
			String constraintPosition = 
					jsonArgs.getJSONObject("constraint").getString("position");
			if (constraintPosition != null){
				targetURI = new URI(jsonArgs.getString("uri")+ "#" + constraintPosition);
			}
		}
		
		TextFragmentIdentifierFactory factory = new TextFragmentIdentifierFactory();
		TextFragmentIdentifier textFragmentIdentifier = 
				factory.createTextFragmentIdentifier(targetURI.getFragment());
		
		URL targetURL = targetURI.toURL();
		URLConnection targetURLConnection = targetURL.openConnection();
		InputStream targetInputStream = targetURLConnection.getInputStream();

		
		String encoding = findEncoding(targetURLConnection);
		
		TextPrimary primary = new TextPrimary(
				IOUtils.toString(targetInputStream, encoding));
		
		targetInputStream.close();
		
		TextConstraint constraint = 
				new TextConstraint(
					textFragmentIdentifier.getCharacterStartPos(primary.getContent()),
					textFragmentIdentifier.getCharacterEndPos(primary.getContent()));

		TextContext context = 
				new TextContext(primary, constraint, HashType.MD5, 20);
				
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("uri", jsonArgs.getString("uri"));
		
		JSONObject jsonConstraint = new JSONObject();
		jsonConstraint.put("checksum", new BigInteger(context.getCheckSum()).toString(16));
		jsonConstraint.put("position", textFragmentIdentifier.getTextScheme());
		
		JSONObject jsonContext = new JSONObject();
		jsonContext.put("before", context.getBeforeContext());
		jsonContext.put("after", context.getAfterContext());
		
		jsonConstraint.put("context", jsonContext.toString());
		
		jsonResult.put("constraint", jsonConstraint);
		
		System.out.println(jsonResult.toString());
		
		return jsonResult.toString();
	}

	
	private String findEncoding(URLConnection targetURLConnection) throws Exception {
		String encoding = targetURLConnection.getContentEncoding();
		if (encoding==null) {
			String contentType = targetURLConnection.getContentType();
			if (contentType.contains("charset")) {
				String[] contentTypeAttributes = contentType.split(";");
				String charsetAttribute = null;
				for (String attribute : contentTypeAttributes) {
					if (attribute.trim().startsWith("charset")) {
						charsetAttribute = attribute;
					}
				}
				if (charsetAttribute != null) {
					encoding = charsetAttribute.trim().substring(
							charsetAttribute.indexOf("=")).toUpperCase();
				}
			}
			if (encoding == null) {
				throw new Exception("no encoding available");
			}
		}
		return encoding;
	}


}
