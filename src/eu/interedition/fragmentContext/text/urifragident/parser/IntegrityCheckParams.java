package eu.interedition.fragmentContext.text.urifragident.parser;

class IntegrityCheckParams {
	String md5;
	Integer length;
	String mimeCharset;
	public IntegrityCheckParams(Integer length, String mimeCharset) {
		super();
		this.length = length;
		this.mimeCharset = mimeCharset;
	}
	public IntegrityCheckParams(String md5, String mimeCharset) {
		super();
		this.md5 = md5;
		this.mimeCharset = mimeCharset;
	}
	
}
