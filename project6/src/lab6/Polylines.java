package lab6;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import plotter.Plotter;
import plotter.Polyline;

public class Polylines {

	
	public static void main(String[] args) throws FileNotFoundException {
		  
		Plotter plotter = new Plotter();
		ArrayList<Polyline> p = new ArrayList<>();
		p = Polylines2("hello.txt");
		Plotter pl = new Plotter();
		for (int x=0; x<p.size(); x++) {
			pl.plot(p.get(x));
		}
	
		
	}
	private static ArrayList<Polyline> Polylines2(String txt) throws FileNotFoundException
	{
		File file = new File(txt);
	    Scanner scanner = new Scanner(file);
	    ArrayList<Polyline> stuff = new ArrayList<>();
	    
	    while (scanner.hasNextLine())
	    {
	      String line = scanner.nextLine().trim();
	      
	      if(line.length() == 0 || line.charAt(0) == '#') {
	    	  continue;
	      }
	      stuff.add(parseOneLine(line));
	    }
	    scanner.close();
		return stuff;
		
		
	}
	
	
	private static Polyline parseOneLine(String line)
	  {
		
		/*
		String[] words = line.split("\\s+");
		
		int i =0;
		if(words.length%2 == 0) {
			Polyline smt = new Polyline(words[1], Integer.parseInt(words[0]));
			
			
			for(int z = 2; z < words.length; z++) {
				smt.addPoint(new Point(z,z+1));
				z+=1;
				
			}return smt;
			
		}else {
			Polyline smt = new Polyline(words[0]);
			for(int z = 1; z < words.length; z++) {
				smt.addPoint(new Point(z,z+1));
				z+=1;
				
			}return smt;
			*/
		
		Scanner scnr = new Scanner(line);
		int wd = 1;
		
		if (scnr.hasNextInt()) {
			wd = scnr.nextInt();
		}
		String color = scnr.next();
		
		Polyline pl = new Polyline(color,wd);
		
		while(scnr.hasNextInt()) {
			int x = scnr.nextInt();
			int y = scnr.nextInt();
			
			pl.addPoint(new Point(x,y));
		}
		return pl;
			
		
	  }
		
			

	

}
