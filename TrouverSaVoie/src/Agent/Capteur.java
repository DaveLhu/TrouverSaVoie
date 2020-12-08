package Agent;

import java.awt.Point;
import java.util.ArrayList;

import Terrain.Forest;

public class Capteur {
	private ArrayList<Point> odeur;
	private ArrayList<Point> vent;
	private ArrayList<Point> lumiere;
	private Forest grille;
	private Point position;
	
	public Capteur(Forest grille, Point position) {
		this.odeur = new ArrayList<Point>();
		this.vent = new ArrayList<Point>();
		this.lumiere = new ArrayList<Point>();
		this.grille = grille;
		this.position = position;
	}
	
	public void getObjet(Point position) {
		int objet = this.grille.getObjet(position);
		switch(objet) {
		case 1:
			System.out.println("on est sur le joueur");
			break;
		case 2:
			System.out.println("on est sur le portail");
			break;
		case 3:
			System.out.println("on est sur le monstre");
			System.out.println("vous avez perdu");
			break;
		case 4:
			System.out.println("on est sur les mauvaises odeurs");
			this.odeur.add(new Point((int) position.getX(), (int) position.getY()));
			System.out.println("odeur en : (" + position.x  + " ; " + position.y + ") ");
			break;
		case 5:
			System.out.println("on est sur la crevasse");
			System.out.println("vous avez perdu");
			break;
		case 6:
			System.out.println("on est sur le vent");
			this.vent.add(new Point((int) position.getX(), (int) position.getY()));
			System.out.println("vent en : (" + position.x  + " ; " + position.y + ") ");
			break;
		default :
			System.out.println("il y a rien");
			break;
		}
	}
	
	public ArrayList<Point> getOdeur() {
		return odeur;
	}
	
	public void setOdeur(Point position) {
		this.odeur.add(position);
	}
	
	public ArrayList<Point> getVent() {
		return vent;
	}
	
	public void setVent(Point position) {
		this.vent.add(position);
	}
	
	public ArrayList<Point> getLumiere() {
		return lumiere;
	}
	
	public void setLumiere(Point position) {
		this.lumiere.add(position);
	}
	
	public Forest getGrille() {
		return grille;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public void cleanLists() {
		this.odeur.clear();
		this.vent.clear();
		this.lumiere.clear();
	}

}
