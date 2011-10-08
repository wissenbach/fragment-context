package eu.interedition.fragmentContext;

import java.net.URI;

public interface FragmentContext {

	public Context generateContext(Primary primary, Fragment fragment);

	public Fragment matchFragment (Primary primary, Context context, Fragment fragment);

}
