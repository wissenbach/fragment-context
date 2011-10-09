package eu.interedition.fragmentContext;


public interface Context {

	public static class NoMatchFoundException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1735078891879900029L;}

	public boolean verify(Primary primary);
	
	public Constraint match(Primary primary) throws Context.NoMatchFoundException;
	
}
