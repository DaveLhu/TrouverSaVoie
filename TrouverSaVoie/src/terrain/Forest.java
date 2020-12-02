package terrain;

import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Forest {
	private int size;
	private int[][] grid;
	private Point portal;
	private Point player;
	private ArrayList<Point> monsters;
	private ArrayList<Point> crevices;
	/* 0 : nothing
	 * 1 : player
	 * 2 : portal
	 * 3 : monsters
	 * 4 : bad odor
	 * 5 : crevice
	 * 6 : wind
	 */
	public void gridInitialisation() {
		
	}
	
	public void initialisation() {
		size = 3;
		grid = new int[size][size];
		spawnMonsters();
		spawnPlayer();
		firePortalGun();
	}
	
	public void spawnPlayer() {
		int x = ThreadLocalRandom.current().nextInt(0, size);
		int y = ThreadLocalRandom.current().nextInt(0, size);
		grid[x][y] = 1;
	}
	
	public void firePortalGun() {
		int x = ThreadLocalRandom.current().nextInt(0, size);
		int y = ThreadLocalRandom.current().nextInt(0, size);
		if (grid[x][y] != 1) {
			grid[x][y] = 2;
		}
	}
	
	public void spawnMonsters() {
		
	}
	
	public void landscapeGenerator() {
		
	}
	
}
