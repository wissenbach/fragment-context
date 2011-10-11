package eu.interedition.fragmentContext;

public abstract class DefaultPrimary implements Primary {
	
	private String mimeType;

	protected DefaultPrimary(String mimeType) {
		super();
		this.mimeType = mimeType;
	}
	
	@Override
	public String getMimeType() {
		return mimeType;
	}
}
