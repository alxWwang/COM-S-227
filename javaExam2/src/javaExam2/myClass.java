package javaExam2;

import java.util.ArrayList;
import java.util.Scanner;

public class myClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b = new Book("Big Java");
		ReferenceBook rb = (ReferenceBook) b;
		
		System.out.println(rb.getTitle());
	}

}
