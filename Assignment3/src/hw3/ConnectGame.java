package hw3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import api.ScoreUpdateListener;
import api.ShowDialogListener;
import api.Tile;

/**
 * Class that models a game.
 */
public class ConnectGame {
	private ShowDialogListener dialogListener;
	private ScoreUpdateListener scoreListener;
	
	/**
	 * Constructs a new ConnectGame object with given grid dimensions and minimum
	 * and maximum tile levels.
	 * 
	 * @param width  grid width
	 * @param height grid height
	 * @param min    minimum tile level
	 * @param max    maximum tile level
	 * @param rand   random number generator
	 */
	private int width = 0;
	private int height = 0;
	private int min = 0;
	private int max = 0;
	private int sameSelectCount =0;
	private Random rand;
	private Grid grid;
	private List<Tile>selected;	
	private boolean startTile;
	private int selectedCount;
	
	private int tempScore = 0;
	private long totalScore = 0;
	public ConnectGame(int width, int height, int min, int max, Random rand) {
		// TODO
		this.width = width;
		this.height = height;
		this.min = min;
		this.max = max;
		this.rand = rand;
		this.totalScore = 0;
		
		selected = new ArrayList<Tile> ();
		grid = new Grid(width, height);
	}

	/**
	 * Gets a random tile with level between minimum tile level inclusive and
	 * maximum tile level exclusive. For example, if minimum is 1 and maximum is 4,
	 * the random tile can be either 1, 2, or 3.
	 * <p>
	 * DO NOT RETURN TILES WITH MAXIMUM LEVEL
	 * 
	 * @return a tile with random level between minimum inclusive and maximum
	 *         exclusive
	 */
	public Tile getRandomTile() {
		// TODO
		int randoms = rand.nextInt((max-min)) + min;
		Tile tl = new Tile(randoms);
		return tl;
	}

	/**
	 * Regenerates the grid with all random tiles produced by getRandomTile().
	 */
	public void radomizeTiles() {
		// TODO
		for(int x = 0; x< width;x++) {
			for(int y =0; y<height; y++) {
				grid.setTile(getRandomTile(), x, y);
			}
		}
		
	}

	/**
	 * Determines if two tiles are adjacent to each other. The may be next to each
	 * other horizontally, vertically, or diagonally.
	 * 
	 * @param t1 one of the two tiles
	 * @param t2 one of the two tiles
	 * @return true if they are next to each other horizontally, vertically, or
	 *         diagonally on the grid, false otherwise
	 */
	public boolean isAdjacent(Tile t1, Tile t2) {
		// TODO
		
		int x1 = t1.getX();
		int y1 = t1.getY();
		int x2 = t2.getX();
		int y2 = t2.getY();
		
		
		if (y1-y2 == 1 && x1==x2 	|| 
			y2-y1 == 1 && x1==x2	|| 
			x1-x2 == 1 && y1==y2 	|| 
			x2-x1 == 1 && y1==y2	||
			x1-x2 == 1 && y1-y2 == 1 ||
			x1-x2 == 1 && y2-y1 == 1 ||
			x2-x1 == 1 && y1-y2 == 1 ||
			x2-x1 == 1 && y2-y1 == 1 		
			) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Indicates the user is trying to select (clicked on) a tile to start a new
	 * selection of tiles.
	 * <p>
	 * If a selection of tiles is already in progress, the method should do nothing
	 * and return false.
	 * <p>
	 * If a selection is not already in progress (this is the first tile selected),
	 * then start a new selection of tiles and return true.
	 * 
	 * @param x the column of the tile selected
	 * @param y the row of the tile selected
	 * @return true if this is the first tile selected, otherwise false
	 */
	public boolean tryFirstSelect(int x, int y) {
		// TODO
		
		if(!startTile) {
			
			grid.getTile(x,y).setSelect(true);
			selected.add(grid.getTile(x, y));
			
			selectedCount =1;
			sameSelectCount =1;
			tempScore += grid.getTile(x,y).getValue();
			startTile = true;
			return true;
			
		}else {
			return false;
		}
	}
	/**
	 * Indicates the user is trying to select (mouse over) a tile to add to the
	 * selected sequence of tiles. The rules of a sequence of tiles are:
	 * 
	 * <pre>
	 * 1. The first two tiles must have the same level.
	 * 2. After the first two, each tile must have the same level or one greater than the level of the previous tile.
	 * </pre>
	 * 
	 * For example, given the sequence: 1, 1, 2, 2, 2, 3. The next selected tile
	 * could be a 3 or a 4. If the use tries to select an invalid tile, the method
	 * should do nothing. If the user selects a valid tile, the tile should be added
	 * to the list of selected tiles.
	 * 
	 * @param x the column of the tile selected
	 * @param y the row of the tile selected
	 */
	public void tryContinueSelect(int x, int y) {
		// TODO
		Tile selec = grid.getTile(x, y);
		Tile prev = selected.get(selected.size()-1)  ;
		
		
		if( isAdjacent(selec, prev)&& startTile) {
			//if is adjacent, and same level, or if more than 2 level +1
			if (selec.getLevel() == prev.getLevel()) {
				//if same level
				sameSelectCount ++;
				selected.add(selec);
				tempScore +=selec.getValue();
				
				selectedCount ++;
				selec.setSelect(true);
				
			}else if (sameSelectCount>=2 && selec.getLevel()- prev.getLevel() == 1){
				//if selected the same twice, and if level selected 1 bigger than before
				sameSelectCount = 1;
				selected.add(selec);
				tempScore += selec.getValue();
				selectedCount ++;
				selec.setSelect(true);
				
			}else if(selected.contains(selec)){
				//if second to last selected
				unselect(selected.get( selected.size() -1).getX(), selected.get(selected.size() -1).getY());
				
			}
			
		}
		
		
	}

	/**
	 * Indicates the user is trying to finish selecting (click on) a sequence of
	 * tiles. If the method is not called for the last selected tile, it should do
	 * nothing and return false. Otherwise it should do the following:
	 * 
	 * <pre>
	 * 1. When the selection contains only 1 tile reset the selection and make sure all tiles selected is set to false.
	 * 2. When the selection contains more than one block:
	 *     a. Upgrade the last selected tiles with upgradeLastSelectedTile().
	 *     b. Drop all other selected tiles with dropSelected().
	 *     c. Reset the selection and make sure all tiles selected is set to false.
	 * </pre>
	 * 
	 * @param x the column of the tile selected
	 * @param y the row of the tile selected
	 * @return return false if the tile was not selected, otherwise return true
	 */
	public boolean tryFinishSelection(int x, int y) {
		// TODO
		
		//last item on list selected[selectedCount -1]
		if(selected.get(selected.size()-1).getX() == x && selected.get(selected.size()-1).getY() == y && startTile) {
			// if location of last item in the list is the same as the input then run
			if(selectedCount == 1) {
				//reset and set to false
				selected.get(selected.size()-1).setSelect(false);
				selected.clear();
				tempScore = 0;
			}else {
				upgradeLastSelectedTile();
				totalScore += tempScore;
				scoreListener.updateScore(totalScore);
			}
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Increases the level of the last selected tile by 1 and removes that tile from
	 * the list of selected tiles. The tile itself should be set to unselected.
	 * <p>
	 * If the upgrade results in a tile that is greater than the current maximum
	 * tile level, both the minimum and maximum tile level are increased by 1. A
	 * message dialog should also be displayed with the message "New block 32,
	 * removing blocks 2". Not that the message shows tile values and not levels.
	 * Display a message is performed with dialogListener.showDialog("Hello,
	 * World!");
	 */
	public void upgradeLastSelectedTile() {
		// TODO
		int upLevel = selected.get(selected.size()-1).getLevel() +1;
		selected.get(selected.size()-1).setLevel(upLevel);
		
		if (selected.get(selected.size()-1).getLevel()>max) {
			//if greater then max
			max ++;
			min ++;
			dialogListener.showDialog("New block "+ Math.pow(2, upLevel) + " removing Blocks" + Math.pow(2,min-1));
			dropSelected();
			dropLevel(min);
		}else {
			dropSelected();
		}
	}

	/**
	 * Gets the selected tiles in the form of an array. This does not mean selected
	 * tiles must be stored in this class as a array.
	 * 
	 * @return the selected tiles in the form of an array
	 */
	public Tile[] getSelectedAsArray() {
		// TODO
		Tile [] arr = new Tile[selected.size()];	
		for(Tile t : selected) {
			arr[selected.indexOf(t)] = t;
		}
		return arr;
	}

	/**
	 * Removes all tiles of a particular level from the grid. When a tile is
	 * removed, the tiles above it drop down one spot and a new random tile is
	 * placed at the top of the grid.
	 * 
	 * @param level the level of tile to remove
	 */
	public void dropLevel(int level) {
		// TODO
		selected.clear();
		for(int x = 0; x< width;x++) {
			for(int y =0; y<height; y++) {
				if(grid.getTile(x, y).getLevel() == level) {
					selected.add(grid.getTile(x, y));
				}
			}
		} dropSelected();
		selected.clear();
	}

	/**
	 * Removes all selected tiles from the grid. When a tile is removed, the tiles
	 * above it drop down one spot and a new random tile is placed at the top of the
	 * grid.
	 */
	public void dropSelected() {
		// TODO
		
		//problem:
		/* IF remove top first, then 
		 * 
		 * 
		 */
		
		for(Tile i : selected) {
			int x = i.getX();
			int y = i.getY();
			
			i.setSelect(false);
			
			if (y==0) {
				grid.setTile(getRandomTile(), x, y);
				continue;
				}
			for(int a = y; a>0; a--) {
			
					Tile temp = grid.getTile(x, a-1);
					Tile temp2 = grid.getTile(x, a);
					grid.setTile(temp, x, a);
					grid.setTile(temp2, x, a-1);
					if (a-1==0) {
						grid.setTile(getRandomTile(), x, 0);
					}
					
			}
		}
		
	}

	/**
	 * Remove the tile from the selected tiles.
	 * 
	 * @param x column of the tile
	 * @param y row of the tile
	 */
	public void unselect(int x, int y) {
		// TODO
		selected.remove(selected.indexOf(grid.getTile(x, y)));
		grid.getTile(x, y).setSelect(false);
		
	}

	/**
	 * Gets the player's score.
	 * 
	 * @return the score
	 */
	public long getScore() {
		// TODO
		return totalScore;
	}

	/**
	 * Gets the game grid.
	 * 
	 * @return the grid
	 */
	public Grid getGrid() {
		// TODO
		return grid;
	}

	/**
	 * Gets the minimum tile level.
	 * 
	 * @return the minimum tile level
	 */
	public int getMinTileLevel() {
		// TODO
		return min;
	}

	/**
	 * Gets the maximum tile level.
	 * 
	 * @return the maximum tile level
	 */
	public int getMaxTileLevel() {
		// TODO
		return max;
	}

	/**
	 * Sets the player's score.
	 * 
	 * @param score number of points
	 */
	public void setScore(long score) {
		// TODO
		this.totalScore = score;
	} 

	/**
	 * Sets the game's grid.
	 * 
	 * @param grid game's grid
	 */
	public void setGrid(Grid grid) {
		// TODO
		this.grid = grid;
	}

	/**
	 * Sets the minimum tile level.
	 * 
	 * @param minTileLevel the lowest level tile
	 */
	public void setMinTileLevel(int minTileLevel) {
		// TODO
		this.min = minTileLevel;
	}

	/**
	 * Sets the maximum tile level.
	 * 
	 * @param maxTileLevel the highest level tile
	 */
	public void setMaxTileLevel(int maxTileLevel) {
		// TODO
		this.max = maxTileLevel;
	}

	/**
	 * Sets callback listeners for game events.
	 * 
	 * @param dialogListener listener for creating a user dialog
	 * @param scoreListener  listener for updating the player's score
	 */
	public void setListeners(ShowDialogListener dialogListener, ScoreUpdateListener scoreListener) {
		this.dialogListener = dialogListener;
		this.scoreListener = scoreListener;
	}

	/**
	 * Save the game to the given file path.
	 * 
	 * @param filePath location of file to save
	 */
	public void save(String filePath) {
		GameFileUtil.save(filePath, this);
	}

	/**
	 * Load the game from the given file path
	 * 
	 * @param filePath location of file to load
	 * @throws FileNotFoundException 
	 */
	public void load(String filePath) throws FileNotFoundException {
		GameFileUtil.load(filePath, this);
	}
}
