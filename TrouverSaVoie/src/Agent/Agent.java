package Agent;

public class Agent extends Thread {
	private Capteur capteur;
	private Effecteur effecteur;
	private volatile boolean runningR = true;
	
	public Agent() {
		this.capteur = new Capteur();
		this.effecteur = new Effecteur(capteur);
	}
	
	
}
