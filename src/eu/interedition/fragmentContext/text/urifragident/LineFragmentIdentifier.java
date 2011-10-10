package eu.interedition.fragmentContext.text.urifragident;

import java.util.Scanner;

public class LineFragmentIdentifier extends TextFragmentIdentifier {
	
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
			characterPos+=curLine.length()+1;
			linePosition++;
		}
				
		return primarySource.length();
	}

	@Override
	public String getTextFragmentFrom(String primarySource) {
		StringBuilder lineRecorder = new StringBuilder();
		Scanner scanner = new Scanner(primarySource);
		int linePosition=0;
		while(scanner.hasNextLine()) {
			String curLine = scanner.nextLine();
			if ((linePosition >= getStartPos()) && (linePosition < getEndPos())) {
				lineRecorder.append(curLine);
			}
			else if (linePosition >= getEndPos()) {
				break;
			}
			linePosition++;
		}
		
		return lineRecorder.toString();
	}

	@Override
	public String getTextSchemeName() {
		return "line=";
	}
}
