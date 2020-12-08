package Agent;

import java.awt.Point;
import java.util.ArrayList;

public class Effecteur {
	private Capteur capteur;
	private Point position;
	private int nbRoche;
	
	public Effecteur(Capteur capteur) {
		this.capteur = capteur;
	}
	
	public void deplacement(String direction) {
		switch(direction) {
		case ("GAUCHE"):
			position.y--;
		break; 
		case ("DROITE"):
			position.y++;
		break;
		case ("HAUT"):
			position.x--;
		break;
		case ("BAS"):
			position.x++;
		break;
		}
	}
	
	public ArrayList<Point> possibilitéDeplacement() {
		ArrayList<Point> possibilities = new ArrayList<Point>();
		Point player = capteur.getPosition();
		int taille = capteur.getGrille().getSize();
		if(player.x == 0 && player.x != taille-1) {
			possibilities.add(new Point(player.x+1,player.y));
			System.out.println("bas");
		}
		else if(player.x != 0 && player.x != taille-1){
			possibilities.add(new Point(player.x+1,player.y));
			possibilities.add(new Point(player.x-1,player.y));
			System.out.println("haut et bas");
		}
		else if(player.x != 0 && player.x == taille-1) {
			possibilities.add(new Point(player.x-1,player.y));
			System.out.println("haut");
		}
		
		if(player.y == 0 && player.y != taille-1) {
			possibilities.add(new Point(player.x,player.y+1));
			System.out.println("droite");
		}
		else if(player.y != 0 && player.y != taille-1){
			possibilities.add(new Point(player.x,player.y+1));
			possibilities.add(new Point(player.x,player.y-1));
			System.out.println("droite et gauche");
		}
		else if(player.y != 0 && player.y == taille-1) {
			possibilities.add(new Point(player.x,player.y-1));
			System.out.println("gauche");
		}		
		return possibilities;
	}

//on stack les roches que l'on peut lancer pour tuer un monstre.
	public void tirer(String shoot) {
		setNbRoche(this.nbRoche - 1);
		
	}
	
	public void sortir(String exit) {
		
	
	}
	
	public Point getPoint() {
		return position;
	}
	
	public void setPosition(Point position) {
		this.position = position; 
	}
	
	public int getNbRoche() {
		return nbRoche;
	}
	
	public void setNbRoche(int nbRoche) {
		this.nbRoche = nbRoche;
	}
	
	
	
}
