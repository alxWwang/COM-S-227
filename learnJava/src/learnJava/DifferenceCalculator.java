package learnJava;

import java.util.Scanner;

public class DifferenceCalculator {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      double diffFractions;
      double num1;
      double num2;
      double den1;
      double den2;
      /* Additional variable declarations go here */
      num1 = scnr.nextInt();
      num2 = scnr.nextInt();
      den1 = scnr.nextInt();
      den2 = scnr.nextInt();

      /* Your code goes here */
      diffFractions = (num1/den1) - (num2/den2);
      
      System.out.print(diffFractions);
   }
}