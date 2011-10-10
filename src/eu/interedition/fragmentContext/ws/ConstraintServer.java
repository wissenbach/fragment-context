package eu.interedition.fragmentContext.ws;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

public class ConstraintServer {
	public static void main(String[] args) throws Exception {
		// Create a new Component.
		final Component component = new Component();

		// Add a new HTTP server listening on port 8182.
		component.getServers().add(Protocol.HTTP, 8182);
		component.getClients().add(Protocol.FILE);
//		component.getClients().add(Protocol.CLAP);
		

		// INDEX PAGE
		
		// URI of the root directory.
		final String ROOT_URI = "file://" + System.getProperty("user.dir")
		+ "/static/";
		
		final Router router = new Router(component.getContext().createChildContext());

		
		router.attach("/create", ConstraintFactory.class);
		router.attach("/", new Directory(component.getContext().createChildContext(),
				ROOT_URI));
		component.getDefaultHost().attach("/oac-constraint", router);
		
		
		component.start();
	}

}
