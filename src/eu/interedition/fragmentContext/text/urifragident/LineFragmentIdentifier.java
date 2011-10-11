package eu.interedition.fragmentContext.text.urifragident;

import java.util.Scanner;

public class LineFragmentIdentifier extends TextFragmentIdentifier {
	
	public final static String SCHEME_NAME = "line";
	
	public LineFragmentIdentifier(Range range) {
		super();
		setRange(range);
	}
	
	public Integer getCharacterStartPos(String primarySource) {
		if (getStartPos() == null) {
			return 0;
		}
		return getCharacterPos(primarySource, getStartPos());
	}
	
	public Integer getCharacterEndPos(String primarySource) {
		if (getEndPos() == null) {
			return primarySource.length();
		}
 		return getCharacterPos(primarySource, getEndPos());
	}
	
	private Integer getCharacterPos(String primarySource, int line) {
		Scanner scanner = new Scanner(primarySource);
		int linePosition=0;
		int characterPos=0;
		while(scanner.hasNextLine()) {
			String curLine = scanner.nextLine();
			if (linePosition == line) {
				return characterPos;
			}
			characterPos+=curLine.length()
					+ (scanner.match().group(1)==null ? 0 : scanner.match().group(1).length());
			
			linePosition++;
		}
				
		return primarySource.length();
	}

	@Override
	public String getTextSchemeName() {
		return SCHEME_NAME + "=";
	}
}
