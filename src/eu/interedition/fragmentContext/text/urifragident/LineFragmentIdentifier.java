package eu.interedition.fragmentContext.text.urifragident;

import java.util.Scanner;

public class LineFragmentIdentifier extends TextFragmentIdentifier {

	
	
	public LineFragmentIdentifier(Range range) {
		super();
		setRange(range);
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
			linePosition++;
		}
		
		return null;
	}

}
