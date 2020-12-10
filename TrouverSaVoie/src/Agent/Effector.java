package Agent;

import java.awt.Point;
import java.util.ArrayList;

public class Effector {
	private Captor captor;
	private Point position;
	private int rocks;
	
	public Effector(Captor captor) {
		this.captor = captor;
	}
	
	public void move(String direction) {
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

	public void shoot(String shoot) {
		rocks++;	
	}
	
	public void exit(String exit) {
		
	}
	
	public Point getPoint() {
		return position;
	}
	
	public void setPosition(Point position) {
		this.position = position; 
	}
	
	public int getRocks() {
		return rocks;
	}
	
	public void setRocks(int rocks) {
		this.rocks = rocks;
	}
	
	
	
}
