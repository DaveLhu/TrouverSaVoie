package Agent;

import java.awt.Point;
import java.util.ArrayList;

import Terrain.Forest;

public class Capteur {
	private ArrayList<Point> odeur;
	private ArrayList<Point> vent;
	private ArrayList<Point> lumiere;
	private Forest grille;
	
	public Capteur(Forest grille) {
		this.odeur = new ArrayList<>();
		this.vent = new ArrayList<>();
		this.lumiere = new ArrayList<>();
		this.grille = grille;

	}
	
	
	public ArrayList<Point> getOdeur() {
		return odeur;
	}
	public void setOdeur(ArrayList<Point> odeur) {
		this.odeur = odeur;
	}
	public ArrayList<Point> getVent() {
		return vent;
	}
	public void setVent(ArrayList<Point> vent) {
		this.vent = vent;
	}
	public ArrayList<Point> getLumiere() {
		return lumiere;
	}
	public void setLumiere(ArrayList<Point> lumiere) {
		this.lumiere = lumiere;
	}
	
	public Forest getGrille() {
		return grille;
	}
	

}
