package Agent;

import java.awt.Point;

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

//on stack les roches que l'on peut lancer pour tuer un monstre.
	public void tirer(String shoot) {
		setNbRoche(this.nbRoche - 1);
		
	}
	
	public void sortit(String exit) {
		
	
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
