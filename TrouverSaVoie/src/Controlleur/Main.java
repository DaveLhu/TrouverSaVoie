package Controlleur;

import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

import Agent.Agent;
import Terrain.Forest;

public class Main {

	public static void main(String[] args) {
		
		Forest forest = new Forest();
		forest.initialisation();
		
		Point p = forest.getPlayer();
		Agent agent = new Agent(p,forest);
				
		forest.start();
		agent.run(); 
	}

}
