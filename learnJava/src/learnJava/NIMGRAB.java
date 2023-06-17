package learnJava;

import java.util.Random;
import java.util.Scanner;

public class NIMGRAB {
    public static void main(String[] args) {
        System.out.println("Welcome to NIMGRAB!");
        System.out.println();
        
        // TODO: Have student print their name/ section when the script runs
        System.out.println("By: Nicholas Alexander Wang");
        System.out.println("[COM S 127 Section A]");
        System.out.println();
        
        // Constant values
        int numItemLow= 4;
        int numItemHigh= 8;
        int numTakeLow = 1;
        int numTakeHigh = 3;
        
        // Game flow variables
        boolean gameOver = false;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        
        while (!gameOver) {
            System.out.print("[p]lay, [i]nstructions, or [q]uit?: ");
            String x = sc.nextLine();
            if (x.equals("p")) {
                System.out.println();
                int numItem = rand.nextInt(numItemHigh - numItemLow + 1) + numItemLow;
                int currentTurn = 0;
                while (true) {
                    if (numItem == 1 ) {
                        if (currentTurn == 1) {
                            System.out.println("The Computer has taken the last item... Therefore, the Human Has Won!");
                            break;
                        } else {
                            System.out.println("The Human has taken the last item... Therefore, the Computer Has Won!");
                            break;
                        }
                    }
                    if (currentTurn == 0) { //Human Turn
                        System.out.println("This is Human's Turn");
                        System.out.println("There are " + numItem + " items in the Pool");
                        for (int i = 0; i < numItem; i++) {
                            System.out.print("| ");
                        }
                        System.out.println();
                        System.out.println();
                        
                        int humanInput;
                        try {
                            humanInput = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("This is not a valid answer");
                            break;
                        }
                        
                        if (humanInput < numTakeLow || humanInput > numTakeHigh) {
                            System.out.println("This is not a valid answer");
                            break;
                        }
                        
                        System.out.println();
                        System.out.println("You have taken " + humanInput);
                        System.out.println();
                        for (int i = 0; i < 30; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        numItem -= humanInput;
                        
                        currentTurn++;
                        
                        
                    } else { //Computer Turn
                        System.out.println("This is Computer's turn");
                        System.out.println("There are " + numItem + " items in the Pool");
                        for (int i = 0; i < numItem; i++) {
                        	System.out.print("|");
                        }
                        
                        System.out.println();
                        System.out.println();
                        
                        int ComputerInput;
                    
                        ComputerInput = rand.nextInt(numTakeLow,numItem);
                        
                       
                        while(true) {
                        	if ((ComputerInput == numItem && numItem == 1)) {
                        		break;
                        	}
                        		
                        	else if ((ComputerInput == numItem) || (ComputerInput > numItem)) {
                        		
                        	
                        		ComputerInput = rand.nextInt(numTakeLow,numTakeHigh);
                        	}
                        	else {
                        		break;
                        	}
                        }
                        	
                        
                        	
                        System.out.println();
                        System.out.println("Computer has taken" + ComputerInput);
                        System.out.println();
                        
                        
                        for(int i = 0; i<30; i++) {
                        	System.out.print("-");
                        }
                        numItem -= ComputerInput;
                        currentTurn -= 1;
                        System.out.print(currentTurn);
                        System.out.println();
                     
                        
                        
                        
                    }
                }
            }
        }
    }
}
                