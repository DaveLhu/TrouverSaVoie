package Agent;

import java.awt.Point;
import java.util.ArrayList;

import Terrain.Forest;

public class Agent extends Thread {
	private Capteur capteur;
	private Effecteur effecteur;
	private volatile boolean runningR = true;
	private Point position;
	private volatile boolean runningA = true;
	
	public Agent(Point position, Forest grille) {
		this.capteur = new Capteur(grille,position);
		this.effecteur = new Effecteur(capteur);
		effecteur.setPosition(position);
		this.position = position;
	}
	
	public void run() {
		while(true) {
			if (capteur.getGrille().running() == true) {
				
				System.out.println("Agent positionné en : " + position.getX()  + " ; " + position.getY() );
				//ArrayList<String> actions = 
				
			}
			while(runningA) {
				try {
					Thread.sleep(3000);
					System.out.println("Agent positionné en : " + position.getX()  + " ; " + position.getY() );
					capteur.getObjet(position);
					effecteur.possibilitéDeplacement();
					//effecteur.deplacement(direction);
					
					
				}catch (InterruptedException e) {
						e.printStackTrace();
				}
			}
		}
	}
	
	public void arreter() {
		this.runningA = false;
	}
}
