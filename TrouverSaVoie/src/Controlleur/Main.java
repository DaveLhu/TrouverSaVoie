package Controlleur;

import java.util.concurrent.ThreadLocalRandom;

import Terrain.Forest;

public class Main {

	public static void main(String[] args) {
		Forest forest = new Forest();
		forest.initialisation();
		forest.start();
	}

}
