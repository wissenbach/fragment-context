package eu.interedition.fragmentContext.ws;

import java.io.InputStream;
import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.restlet.routing.Router;

import eu.interedition.fragmentContext.text.TextContext;
import eu.interedition.fragmentContext.text.TextContext.HashType;
import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifier;
import eu.interedition.fragmentContext.text.urifragident.TextFragmentIdentifierFactory;


public class TextFragmentIdentifierResolver extends ServerResource{
	
	@Post
	public String resolve(String args) throws Exception {
		System.out.println(args);
		JSONObject jsonArgs = new JSONObject(args);
		JSONArray targets = jsonArgs.getJSONArray("targets");
		JSONObject firstTarget = targets.getJSONObject(0);
		
		URI targetURI = new URI(firstTarget.getString("uri"));
		
		TextFragmentIdentifierFactory factory = new TextFragmentIdentifierFactory();
		TextFragmentIdentifier textFragmentIdentifier = 
				factory.createTextFragmentIdentifier(targetURI.getFragment());
		
		InputStream targetInputStream = targetURI.toURL().openStream();
		
		byte[] md5Byte = TextContext.checkSum(IOUtils.toString(targetInputStream, "UTF-8"), HashType.MD5);
		
		
		
		
		return "tst";
	}

	
	public static void main(String[] args) throws Exception {
		// Create a new Component.
		final Component component = new Component();

		// Add a new HTTP server listening on port 8182.
		component.getServers().add(Protocol.HTTP, 8182);

		final Router router = new Router(component.getContext().createChildContext());

		router.attach("/textfragmentidentifier", TextFragmentIdentifierResolver.class);
		component.getDefaultHost().attach("/fragmentcontext", router);
		
		component.start();
	}
}
