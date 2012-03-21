package eu.interedition.fragmentContext.ws;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class ConstraintService extends Application {
	
	
	@Override
	public synchronized Restlet createInboundRoot() {
		
		// URI of the root directory.
		final Router router = new Router(getContext());

		router.attach("/create", ConstraintFactory.class);
		router.attach("/match", ConstraintMatcher.class);
		
		router.attach("/", InfoProvider.class);

		
		return router;
	}
	
	

}
