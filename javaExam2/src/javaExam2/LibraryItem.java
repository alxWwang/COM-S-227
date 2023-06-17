package javaExam2;

public abstract class LibraryItem implements Item{
	private String title;
	private int checkOut;
	
	
	protected LibraryItem(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	
	public int getCheckOutPeriod() {
		return checkOut;
	}
	
	protected void setCheckOut (int checkOut) {
		this.checkOut = checkOut;
	}
	
}
