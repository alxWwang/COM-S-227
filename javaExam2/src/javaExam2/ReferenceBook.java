package javaExam2;

public class ReferenceBook extends Book {

	protected ReferenceBook(String title) {
		super(title);
		setCheckOut(0);
		// TODO Auto-generated constructor stub
	}
	
	public String getTitle() {
		return "REF: " + super.getTitle();	
	}
	
	
}
