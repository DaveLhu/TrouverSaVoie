package Agent;

import java.awt.Point;
import java.util.ArrayList;
import Terrain.Forest;

public class Captor {
	private ArrayList<Point> smells;
	private ArrayList<Point> winds;
	private Forest forest;
	
	public Captor(Forest forest) {
		this.smells = new ArrayList<Point>();
		this.winds = new ArrayList<Point>();
		this.forest = forest;
	}
	
	public void getObject(Point position) {
		switch(forest.getObject(position)) {
		case 2:
			System.out.println("on est sur le portail ! c'est gagné !");
			break;
		case 3:
			System.out.println("*un monstre vous découpe en plusieurs morceaux*");
			System.out.println("(vous êtes mort mais on vous redonne une autre vie gratuitement !)");
			break;
		case 4:
			System.out.println("wow ça sent mauvais !");
			this.smells.add(new Point((int) position.getX(), (int) position.getY()));
			break;
		case 5:
			System.out.println("*vous tombez dans un vide interminable et mourrez litéralement d'ennui*");
			System.out.println("(vous êtes mort mais on vous redonne une autre vie gratuitement !)");
			break;
		case 6:
			System.out.println("ça souffle fort ici !");
			this.winds.add(new Point((int) position.getX(), (int) position.getY()));
			break;
		default :
			System.out.println("rien de spécial à signaler.");
			break;
		}
	}
	
	public ArrayList<Point> movesAvailable() {
		ArrayList<Point> possibilities = new ArrayList<Point>();
		Point agent = getPosition();
		int size = forest.getSize();
		
		if (agent.x > 0) {
			System.out.println("HAUT");
			possibilities.add(new Point(agent.x-1,agent.y));
		}
		if (agent.x < size-1) {
			System.out.println("BAS");
			possibilities.add(new Point(agent.x+1,agent.y));
		}
		if (agent.y > 0) {
			System.out.println("GAUCHE");
			possibilities.add(new Point(agent.x,agent.y-1));
		}	
		if (agent.y < size-1) {
			System.out.println("DROITE");
			possibilities.add(new Point(agent.x,agent.y+1));
		}
		return possibilities;
	}
	
	public Point getPosition() {
		return forest.getPlayer();
	}
	
	public void cleanLists() {
		this.smells.clear();
		this.winds.clear();
	}
	
	public ArrayList<Point> getSmells() {
		return smells;
	}

	public void setSmells(ArrayList<Point> smells) {
		this.smells = smells;
	}

	public ArrayList<Point> getWinds() {
		return winds;
	}

	public void setWinds(ArrayList<Point> winds) {
		this.winds = winds;
	}

	public Forest getForest() {
		return forest;
	}

	public void setForest(Forest forest) {
		this.forest = forest;
	}


}
