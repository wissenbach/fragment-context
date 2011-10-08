package eu.interedition.fragmentContext;

public interface Context {

	public boolean verify(Primary primary);
	
	public Constraint match(Primary primary);
	
}
