package Controlleur;

import java.awt.Point;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Agent.Agent;
import Terrain.Forest;

public class Main {

	public static void main(String[] args) throws IOException {
		//objets
		Forest forest = new Forest();
		Agent agent = new Agent(forest.getPlayer(),forest);
		Scanner scan = new Scanner(System.in);
		
		//méthodes
		forest.initialisation();
		
		while (true) {
		    System.out.println("Appuyez sur enter pour bouger l'agent");
		    scan.nextLine();
		    agent.inference();
		    forest.printGrid();
			
		}

	}

}
