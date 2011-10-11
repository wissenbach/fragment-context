package eu.interedition.fragmentContext.text;

import eu.interedition.fragmentContext.DefaultPrimary;

public class TextPrimary extends DefaultPrimary {

	private String content;
	
	public TextPrimary(String content, String mimeType) {
		super(mimeType);
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
