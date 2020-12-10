package Agent;

import java.awt.Point;
import java.util.ArrayList;

import Terrain.Forest;

public class Agent {
	private Captor captor;
	private Effector effector;

	public Agent(Point position, Forest grille) {
		this.captor = new Captor(grille);
		this.effector = new Effector(captor);
		effector.setPosition(position);
	}

	public void inference() {
		ArrayList<Point> moves = captor.movesAvailable();
	}

}
