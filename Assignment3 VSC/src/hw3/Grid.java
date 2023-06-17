 package hw3;

import java.util.ArrayList;
import java.util.List;

import api.Tile;

/**
 * Represents the game's grid.
 */
public class Grid {
	
	/**
	 * Creates a new grid.
	 * 
	 * @param width  number of columns
	 * @param height number of rows
	 */
	
	private int width;
	private int height;
	private List<List<Tile>> tiles;
	private List<Tile> x;
	
	public Grid(int width, int height) {
		// TODO
		this.width = width;
		this.height = height;
		tiles = new ArrayList<>();
		
		
		for (int y = 0; y<height; y++) {
			x = new ArrayList<Tile>();
			for (int x2 = 0; x2<width; x2++) {
				x.add(null);
			}
			tiles.add(x);
		}	
	}

	/**
	 * Get the grid's width.
	 * 
	 * @return width
	 */
	public int getWidth() {
		// TODO
		return width;
	}

	/**
	 * Get the grid's height.
	 * 
	 * @return height
	 */
	public int getHeight() {
		// TODO
		return height ;
	}

	/**
	 * Gets the tile for the given column and row.
	 * 
	 * @param x the column
	 * @param y the row
	 * @return
	 */
	public Tile getTile(int x, int y) {
		// TODO
		return tiles.get(y).get(x);
		

	}

	/**
	 * Sets the tile for the given column and row. Calls tile.setLocation().
	 * 
	 * @param tile the tile to set
	 * @param x    the column
	 * @param y    the row
	 */
	public void setTile(Tile tile, int x, int y) {
		tile.setLocation(x,y);
		tiles.get(y).set(x, tile);
		
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int y=0; y<getHeight(); y++) {
			if (y > 0) {
				str += "\n";
			}
			str += "[";
			for (int x=0; x<getWidth(); x++) {
				if (x > 0) {
					str += ",";
				}
				str += getTile(x, y);
			}
			str += "]";
		}
		return str;
	}
}
