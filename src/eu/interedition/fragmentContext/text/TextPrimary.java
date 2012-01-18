package eu.interedition.fragmentContext.text;

import eu.interedition.fragmentContext.Primary;

public class TextPrimary implements Primary {

	private String content;
	
	public TextPrimary(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
	
	@Override
	public String getMimeType() {
		return "text/plain";
	}
}
