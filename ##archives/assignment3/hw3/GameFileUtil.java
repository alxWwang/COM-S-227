package hw3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import api.Tile;

/**
 * Utility class with static methods for saving and loading game files.
 */
public class GameFileUtil {
	/**
	 * Saves the current game state to a file at the given file path.
	 * <p>
	 * The format of the file is one line of game data followed by multiple lines of
	 * game grid. The first line contains the: width, height, minimum tile level,
	 * maximum tile level, and score. The grid is represented by tile levels. The
	 * conversion to tile values is 2^level, for example, 1 is 2, 2 is 4, 3 is 8, 4
	 * is 16, etc. The following is an example:
	 * 
	 * <pre>
	 * 5 8 1 4 100
	 * 1 1 2 3 1
	 * 2 3 3 1 3
	 * 3 3 1 2 2
	 * 3 1 1 3 1
	 * 2 1 3 1 2
	 * 2 1 1 3 1
	 * 4 1 3 1 1
	 * 1 3 3 3 3
	 * </pre>
	 * 
	 * @param filePath the path of the file to save
	 * @param game     the game to save
	 */
	public static void save(String filePath, ConnectGame game) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
			// TODO: write to file, can use writer.write()
			 writer.write(game.getGrid().getWidth() + " " + game.getGrid().getHeight() + " " + game.getMinTileLevel() + " "
		                + game.getMaxTileLevel() + " " + (int) game.getScore());
		     writer.newLine();
			
		     for (int y = 0; y < game.getGrid().getHeight(); y++) {
		            for (int x = 0; x < game.getGrid().getWidth(); x++) {
		            	
		                int level = game.getGrid().getTile(x, y).getLevel();
		            
		                if (x < game.getGrid().getWidth() - 1) {
		                    writer.write(level + " ");
		                }else if( y < game.getGrid().getHeight()-1) {
		                	writer.write(level + "\n");
		                }else {
		                	writer.write(level+"");
		                }
		            }
		        }
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads the file at the given file path into the given game object. When the
	 * method returns the game object has been modified to represent the loaded
	 * game.
	 * <p>
	 * See the save() method for the specification of the file format.
	 * 
	 * @param filePath the path of the file to load
	 * @param game     the game to modify
	 * @throws FileNotFoundException 
	 */
	public static void load(String filePath, ConnectGame game) {
		File f = new File(filePath);
		Scanner scnr;
		try {
			scnr = new Scanner(f);
			String line = scnr.nextLine();
			Scanner scLine = new Scanner(line);
			int width = scLine.nextInt();
			int height = scLine.nextInt();
			int min = scLine.nextInt();
			int max = scLine.nextInt();
			long score = scLine.nextInt();
				//scans the initial object
			Grid g = new Grid(width, height);
			game.setGrid(g);
			game.setMaxTileLevel(max);
			game.setMinTileLevel(min);
			game.setScore(score);
				
				
			while(scnr.hasNextLine()) {
				for(int y = 0; y< height;y++) {
					line = scnr.nextLine();
					Scanner scLine2 = new Scanner(line);
					for(int x=0; x<width; x++) {
						int tempLevel = scLine2.nextInt();
						 Tile tile = new Tile(tempLevel);
						 tile.setLocation(x, y);
						 game.getGrid().setTile(tile, x, y);
						 
					}
				}
				
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}

