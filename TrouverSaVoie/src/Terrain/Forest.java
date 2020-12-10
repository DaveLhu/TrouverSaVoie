package Terrain;

import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Forest {
	private int size;
	private int[][] grid;
	private Point player;
	
	/* 0 : nothing
	 * 1 : agent
	 * 2 : portal
	 * 3 : monsters
	 * 4 : bad odor
	 * 5 : crevice
	 * 6 : wind
	 */
	
	public void initialisation() {
		size = 3;
		grid = new int[size][size];
		generateBiome();
		player = spawnPlayer();
		firePortalGun();
		printGrid();
	}
	
	public void nextLevel() {
		printGrid();
		size++;
		initialisation();
	}
	
	public Point spawnPlayer() {
		int x = 0;
		int y = 0;
		while (grid[x][y] != 0) {
			x = ThreadLocalRandom.current().nextInt(0, size);
			y = ThreadLocalRandom.current().nextInt(0, size);
		}
		grid[x][y] = 1;
		return new Point(x,y);
	}
	
	public void firePortalGun() {
		int x = 0;
		int y = 0;
		while (grid[x][y] != 0) {
			x = ThreadLocalRandom.current().nextInt(0, size);
			y = ThreadLocalRandom.current().nextInt(0, size);
		}
		grid[x][y] = 2;
	}
	
	public Boolean generateEnvironment(int x, int y, int type) {
		Boolean[] limits = new Boolean[]{false,false,false,false};
		if (x+1 != size) {
			if (grid[x+1][y] != 0) {
				return false;
			}
		}
		else {
			limits[0] = true;
		}
		if (x-1 >= 0) {
			if (grid[x-1][y] != 0) {
				return false;
			}
		}
		else {
			limits[1] = true;
		}
		if (y+1 != size) {
			if (grid[x][y+1] != 0) {
				return false;
			}
		}
		else {
			limits[2] = true;
		}
		if (y-1 >= 0) {
			if (grid[x][y-1] != 0) {
				return false;
			}
		}
		else {
			limits[3] = true;
		}
		//application des changements
		if (limits[0] == false) {
			grid[x+1][y] = type;
		}
		if (limits[1] == false) {
			grid[x-1][y] = type;
		}
		if (limits[2] == false) {
			grid[x][y+1] = type;
		}
		if (limits[3] == false) {
			grid[x][y-1] = type;
		}
		return true;
	}
	
	public void generateBiome() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (ThreadLocalRandom.current().nextInt(0, size) == size-1 && grid[i][j] == 0) {
					if (ThreadLocalRandom.current().nextInt(0, 2) == 1) {
						int x = i;
						int y = j;
						while (generateEnvironment(x,y,4) == false) {
							x = ThreadLocalRandom.current().nextInt(0, size);
							y = ThreadLocalRandom.current().nextInt(0, size);
						}
						grid[x][y] = 3;
					}
					else {
						int x = i;
						int y = j;
						while (generateEnvironment(x,y,6) == false) {
							x = ThreadLocalRandom.current().nextInt(0, size);
							y = ThreadLocalRandom.current().nextInt(0, size);
						}
						grid[x][y] = 5;
					}
				}
			}
		}
	}
	
	public void printGrid() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (grid[i][j] == 1) {
					System.out.print("A" + " ");
				}
				else if (grid[i][j] == 2) {
					System.out.print("P" + " ");
				}
				else if (grid[i][j] == 3) {
					System.out.print("M" + " ");
				}
				else if (grid[i][j] == 4) {
					System.out.print("&" + " ");
				}
				else if (grid[i][j] == 5) {
					System.out.print("C" + " ");
				}
				else if (grid[i][j] == 6) {
					System.out.print("~" + " ");
				}
				else {
					System.out.print(grid[i][j] + " ");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void killMonster(Point point) {
		int x = point.x;
		int y = point.y;
		grid[x][y] = 0;
		//suppression odeur
		if (x+1 != size) {
			grid[x+1][y] = 0;
		}
		if (x-1 >= 0) {
			grid[x-1][y] = 0;
		}
		if (y+1 != size) {
			grid[x][y+1] = 0;
		}
		if (y-1 >= 0) {
			grid[x][y-1] = 0;
		}
	}

	public int getObject(Point position) {
		return this.grid[position.x][position.y];
	}

	public Point getPlayer() {
		return this.player;
	}
	
	public int getSize() {
		return this.size;
	}
}
