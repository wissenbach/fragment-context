package eu.interedition.fragmentContext.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

import eu.interedition.fragmentContext.text.TextPrimary;

public class ArgumentsParser {
	
	public enum Field {
		uri,
		constraint,
		position, 
		checksum, 
		before, 
		after, 
		context,
	}
	
	private JSONObject args;
	private URI targetURI;

	public ArgumentsParser(JSONObject args) {
		super();
		this.args = args;
	}
	
	public URI getTargetURI() throws URISyntaxException, JSONException {
		if (this.targetURI == null) {
			this.targetURI = new URI(args.getString(Field.uri.name()));
			if ((this.targetURI.getFragment() == null) 
					&& (args.has(Field.constraint.name()))) { 
				
				JSONObject jsonConstraints = args.getJSONObject(Field.constraint.name());
				if (jsonConstraints.has(Field.position.name())) {
					String constraintPosition = 
							jsonConstraints.getString(Field.position.name());
					if (constraintPosition != null){
						String extURI = 
								args.getString(Field.uri.name()) 
								+ "#" + constraintPosition;
						this.targetURI = new URI(extURI);
						args.put(Field.uri.name(), extURI);
					}
				}
				
			}
		}		
		return this.targetURI;
	}

	public String getMd5HexValue() throws JSONException {
		return args.getJSONObject(Field.constraint.name()).getString(Field.checksum.name());
	}
	
	public TextPrimary getPrimary() throws Exception {
		URL targetURL = targetURI.toURL();
		URLConnection targetURLConnection = targetURL.openConnection();
		InputStream targetInputStream = targetURLConnection.getInputStream();

		String encoding = findEncoding(targetURLConnection);
		String mimeType = findMimeType(targetURLConnection);
		
		TextPrimary primary = new TextPrimary(
//				IOUtils.toString(targetInputStream, encoding), mimeType);
				streamToString(targetInputStream, encoding), mimeType);
		targetInputStream.close();
		
		return primary;

	}
	
	private String streamToString(InputStream is, String charset) throws IOException {
		StringBuilder contentBuffer = new StringBuilder();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader( is, charset ) );
		
		char[] buf = new char[65536];
		int cCount = -1;
        while((cCount=reader.read(buf)) != -1) {
        	contentBuffer.append( buf, 0, cCount);
        }

        return contentBuffer.toString();
	}
	
	
	
	
	private String findMimeType(URLConnection targetURLConnection) {
		String contentType = targetURLConnection.getContentType();
		String mimeType = null;
		if (contentType != null) {
			String[] contentTypeAttributes = contentType.split(";");
			if (contentTypeAttributes.length > 0) {
				mimeType  = contentTypeAttributes[0];
			}
		}
		if (mimeType == null) {
			mimeType = "text/plain";
			// throw new Exception("no mimetype available");
		}
		return mimeType;
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
				encoding = "UTF-8";
				//throw new Exception("no encoding available");
			}
		}
		return encoding;
	}

	public String getBeforeContext() throws JSONException {
		String context = 
				args.getJSONObject(
						Field.constraint.name()).getString(Field.context.name());
		JSONObject jsonContext = new JSONObject(context);
		
		return jsonContext.getString(Field.before.name());
	}

	public String getAfterContext() throws JSONException {
		String context = 
				args.getJSONObject(
						Field.constraint.name()).getString(Field.context.name());
		JSONObject jsonContext = new JSONObject(context);
		
		return jsonContext.getString(Field.after.name());
	}

}
