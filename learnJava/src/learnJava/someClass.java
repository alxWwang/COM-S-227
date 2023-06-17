package learnJava;

import java.util.Scanner;

public class someClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		
		int howmany;
		boolean clubmember;
		String clubMemberQ;
		double total = 0;
		
		
		System.out.print("How many?");
		howmany = scnr.nextInt();
		System.out.println("");
		
		System.out.print("Club member (Y.n) :");
		clubMemberQ = scnr.next();
		
		if(clubMemberQ.equals("y")) {
			clubmember = true;
		}else {
			clubmember = false;
		}
		
		if(howmany <= 10) {
			total += 15*howmany;
		}else if ( howmany > 10 && howmany < 100) {
			total += 12* (howmany -10);
			total += 15*10;
		}else if (howmany > 100) {
			total += 8*(howmany-110);
			total += 12*100;
			total += 15*10;
		}
		
		
		
		total = total/100;
		
		
		if (clubmember) {
			total -= total * 0.1;
		}
		
		
		
		System.out.println("Total : "+ total);
		
	}

}
