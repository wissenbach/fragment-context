package eu.interedition.fragmentContext;

import java.net.URI;

public interface FragmentContext {

	public Context generateContext(Primary primary, Constraint fragment);

	public Constraint matchFragment (Primary primary, Context context, Constraint fragment);

}
