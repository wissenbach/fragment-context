package eu.interedition.fragmentContext;


public interface FragmentContext {

	public Context generateContext(Primary primary, Constraint fragment);

	public Constraint matchFragment (Primary primary, Context context, Constraint fragment);

}
