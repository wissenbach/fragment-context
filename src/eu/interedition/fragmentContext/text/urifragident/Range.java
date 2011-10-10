package eu.interedition.fragmentContext.text.urifragident;

public class Range {
	private Integer startPos;
	private Integer endPos;

	public Range() {
		super();
	}
	
	public Range(String position) {
		super();
		setStartPos(position);
		setEndPos(position);
	}

	public Range(int startPos, int endPos) {
		this.startPos = startPos;
		this.endPos = endPos;
	}

	public Integer getStartPos() {
		return startPos;
	}
	
	public void setStartPos(String startPos) {
		this.startPos = (startPos == null) ? null : Integer.valueOf(startPos);
	}
	
	public Integer getEndPos() {
		return endPos;
	}
	
	public void setEndPos(String endPos) {
		this.endPos = (endPos == null) ? null : Integer.valueOf(endPos);
	}

	@Override
	public String toString() {
		return "["+getStartPos()+","+getEndPos()+"]";
	}

}
