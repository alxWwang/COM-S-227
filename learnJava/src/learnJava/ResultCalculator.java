package learnJava;
import java.util.Scanner;

import java.util.Scanner;

public class ResultCalculator {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int numInput;
      int finalVal;
   
      finalVal = 0;
      numInput = scnr.nextInt();
   
      /* Your code goes here */
      while(numInput %4 == 0){

         finalVal -= numInput;
         numInput = scnr.nextInt();
         
        
      } 
      if(numInput%4 == 0){
         finalVal -= numInput;
         }
      
      
   
      System.out.println("Final value is " + finalVal);
   }
}