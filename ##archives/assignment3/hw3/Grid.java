package hw3;

import java.util.ArrayList;

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
	private int x;
	private int y;
	private Tile[][] tiles;

	public Grid(int width, int height) {
		// TODO
		this.x = width;
		this.y = height;
		tiles = new Tile[x][y];
		
	}

	/**
	 * Get the grid's width.
	 * 
	 * @return width
	 */
	public int getWidth() {
		// TODO
		return x;
	}

	/**
	 * Get the grid's height.
	 * 
	 * @return height
	 */
	public int getHeight() {
		// TODO
		return y;
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
		return tiles[x][y];
	}

	/**
	 * Sets the tile for the given column and row. Calls tile.setLocation().
	 * 
	 * @param tile the tile to set
	 * @param x    the column
	 * @param y    the row
	 */
	public void setTile(Tile tile, int x, int y) {
		// TODO
		tile.setLocation(x, y);
		tiles[x][y] = tile;
		//fliped x and y and then it worked
		
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
