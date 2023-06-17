package lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class LineNumberer2 {
	
	public static void read(String txt) throws FileNotFoundException
	{
		File file = new File(txt);
	    Scanner scanner = new Scanner(file);
	    int lineCount = 1;

	    while (scanner.hasNextLine())
	    {
	      String line = scanner.nextLine();
	      System.out.print(lineCount + " ");
	      System.out.println(line);
	      lineCount += 1;
	    }
	    scanner.close();
		
		
	}
	
	public static void read2(String fileName) throws FileNotFoundException
	{
		File file = new File(fileName);
		Scanner scnr = new Scanner(file);
		
		while(scnr.hasNextLine()) {
				String line = scnr.nextLine();
				 // String[] words = line.split("\\s+");
				Scanner scnr2 = new Scanner(line);
				int counter = 0;
				while( scnr2.hasNext()) {
					counter ++;
					scnr2.next();
					
				}
				
				System.out.println(counter);
				/*
				if(words.length == 1) {
					System.out.println("0");
				}
				else {
					System.out.println(words.length);
				}
				*/
			
		}
		
		
		scnr.close();
		
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		read("/Users/wang/Documents/ISU/COM S 227/project5/src/lab5/testing.java");
		System.out.println();
		read2("story.txt");
		
	}
	

}
