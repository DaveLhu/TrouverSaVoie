package Agent;

import java.awt.Point;

import Terrain.Forest;

public class Agent extends Thread {
	private Capteur capteur;
	private Effecteur effecteur;
	private volatile boolean runningR = true;
	private Point point;
	
	public Agent(Point position, Forest grille) {
		this.capteur = new Capteur(grille);
		this.effecteur = new Effecteur(capteur);
		effecteur.setPosition(position);
	}
	
	public void run() {
		while(true) {
			//if ()
		}
	}
	
}
