package learnJava;
import java.util.Scanner;

public class scannerAn {
    public static void main(String[] args) {

    try (Scanner scnr = new Scanner(System.in)) {
        System.out.print("Enter month :");
        int birthMonth = scnr.nextInt();


        System.out.print("Enter year :");
        int birthYear = scnr.nextInt();

        System.out.println(birthMonth +"/" + birthYear);
    }
    }
}
