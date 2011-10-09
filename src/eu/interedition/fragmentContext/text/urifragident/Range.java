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

	public Integer getStartPos() {
		return startPos;
	}
	
	public void setStartPos(String startPos) {
		this.startPos = Integer.valueOf(startPos);
	}
	
	public Integer getEndPos() {
		return endPos;
	}
	
	public void setEndPos(String endPos) {
		this.endPos = Integer.valueOf(endPos);
	}

	@Override
	public String toString() {
		return "["+getStartPos()+","+getEndPos()+"]";
	}

}
