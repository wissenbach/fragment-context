package eu.interedition.fragmentContext.ws;

import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class ConstraintServer {
	public static void main(String[] args) throws Exception {
		// Create a new Component.
		final Component component = new Component();

		// Add a new HTTP server listening on port 8182.
		component.getServers().add(Protocol.HTTP, 8182);

		final Router router = new Router(component.getContext().createChildContext());

		router.attach("/create", ConstraintFactory.class);
		component.getDefaultHost().attach("/oac-constraint", router);
		
		
		component.start();
	}

}
