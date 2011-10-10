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

		// INDEX PAGE
		
		// URI of the root directory.
		final String ROOT_URI = "file:///" + System.getProperty("user.dir")
		+ "/static/";

		// Create an application
		Application application = new Application() {
		    @Override
		    public Restlet createInboundRoot() {
		            return new Directory(getContext(), ROOT_URI);
		    }
		};

		// Attach the application to the component and start it
		component.getDefaultHost().attach(application);
		
		
		final Router router = new Router(component.getContext().createChildContext());

		router.attach("/create", ConstraintFactory.class);
		component.getDefaultHost().attach("/oac-constraint", router);
		
		router.attach("/match", ConstraintMatcher.class);
		component.getDefaultHost().attach("/oac-constraint", router);
		
		component.start();
	}

}
