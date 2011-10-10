package eu.interedition.fragmentContext.text.urifragident;


public class CharFragmentIdentifier extends TextFragmentIdentifier {

	public CharFragmentIdentifier(Range range) {
		super();
		setRange(range);
	}

	@Override
	public String getTextFragmentFrom(String primarySource) {
		return primarySource.substring(getStartPos(), getEndPos());
	}

	@Override
	public String getTextSchemeName() {
		return "char=";
	}

}
