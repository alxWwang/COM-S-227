package javaExam2;

public class DVD extends LibraryItem {
	
	private int duration;
	
	protected DVD(String title, int duration) {
		super(title);
		setCheckOut(7);
		this.duration = duration;
		// TODO Auto-generated constructor stub
	}
	
	public String getTitle() {
		return "DVD: " + super.getTitle();
	}

	
	public int getDuration() {
		return duration;
	}
	
}
