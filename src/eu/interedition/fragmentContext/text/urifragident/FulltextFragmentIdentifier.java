package eu.interedition.fragmentContext.text.urifragident;

class FulltextFragmentIdentifier extends TextFragmentIdentifier {

	public FulltextFragmentIdentifier() {
		setRange(new Range(null));
	}
	
	@Override
	public String getTextFragmentFrom(String primarySource) {
		return primarySource;
	}

	@Override
	public String getTextSchemeName() {
		return "";
	}

}
