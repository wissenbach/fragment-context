package eu.interedition.fragmentContext.text;

import eu.interedition.fragmentContext.Constraint;

public class TextConstraint implements Constraint {

	public TextConstraint(int startPos, int endPos) {
		super();
		this.startPos = startPos;
		this.endPos = endPos;
	}
	
	private int startPos;
	
	private int endPos;

	public int getStartPos() {
		return startPos;
	}

	public int getEndPos() {
		return endPos;
	}

	@Override
	public boolean equals(Object arg0) {
		if (!(arg0 instanceof TextConstraint)) return false;
		return this.startPos == ((TextConstraint)arg0).startPos &&
		this.endPos == ((TextConstraint)arg0).endPos;
	}
	
	@Override
	public String toString() {
		return TextConstraint.class.getSimpleName() + "[" + startPos + ", " + endPos + "]";
	}
}
