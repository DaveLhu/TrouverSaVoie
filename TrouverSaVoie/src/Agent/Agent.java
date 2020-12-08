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

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Agent positionné en : (" + position.x  + " ; " + position.y +")" );
				capteur.getObjet(position);
				ArrayList<String> possibilites = effecteur.possibilitéDeplacement();
				//imposer premier mouvement
				/*int nbPos = possibilites.size();
				int r = (int) (Math.random() * (nbPos - 1)) + 1;
				effecteur.deplacement(possibilites.get(r));
				System.out.println("Agent positionné en : " + position.getX()  + " ; " + position.getY() );
				capteur.getObjet(position);
				starterProbleme(capteur.getOdeur(),capteur.getVent(),capteur.getLumiere());

				 */
				//ArrayList<String> actions = 

				//faire tous les premiers mouvements possibles
				Point positionPrecedent = new Point(position.x,position.y);
				for(int i = 0; i<possibilites.size();i++) {
					effecteur.deplacement(possibilites.get(i));
					System.out.println("Agent positionné en : (" + position.x  + " ; " + position.y + ") ");
					capteur.getObjet(position); 
					position.setLocation(positionPrecedent);
				}
				
				starterProbleme(capteur.getOdeur(),capteur.getVent(),capteur.getLumiere());

				
			}
			while(runningA) {
				try {
					Thread.sleep(2000);
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

	public ArrayList<String> starterProbleme(ArrayList<Point> odeur, ArrayList<Point> vent, ArrayList<Point> lumiere ){
		ArrayList<String> actions = new ArrayList<String>();

		int maxSize = Math.max(odeur.size(),vent.size());
		maxSize = Math.max(maxSize,lumiere.size());
		maxSize = Math.max(maxSize,3);
		int[][] objets = new int[maxSize][maxSize];
		for(int i = 0; i<odeur.size();i++) {
			objets[(int) odeur.get(i).getX()][(int) odeur.get(i).getY()] = 4;
		}
		for(int i = 0; i<vent.size();i++) {
			objets[(int) vent.get(i).getX()][(int) vent.get(i).getY()] = 6;
		}
		for(int i = 0; i<lumiere.size();i++) {
			objets[(int) lumiere.get(i).getX()][(int) lumiere.get(i).getY()] = 7;
		}

		for (int i = 0; i < maxSize; i++) {
			for (int j = 0; j < maxSize; j++) {
				if (objets[i][j] == 1) {
					System.out.print("P" + " ");
				}
				else if (objets[i][j] == 2) {
					System.out.print("X" + " ");
				}
				else if (objets[i][j] == 3) {
					System.out.print("M" + " ");
				}
				else if (objets[i][j] == 4) {
					System.out.print("&" + " ");
				}
				else if (objets[i][j] == 5) {
					System.out.print("C" + " ");
				}
				else if (objets[i][j] == 6) {
					System.out.print("~" + " ");
				}
				else {
					System.out.print(objets[i][j] + " ");
				}
			}
			System.out.println("");
		}
		System.out.println("");




		return actions;
	}

}
