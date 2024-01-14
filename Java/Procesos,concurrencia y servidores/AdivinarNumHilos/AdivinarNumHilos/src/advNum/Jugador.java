package advNum;

public class Jugador extends Thread{
	String nameJ;
	Arbitro arbi;
	
		
		
	public Jugador(String name, Arbitro arbi) {
		this.arbi=arbi;
		this.nameJ = name;
		
		}
		
		public void run() {
	        super.run();
	        if(arbi.finJuego==false) {
	        	int numJug = arbi.genNumAlt(1,10);
	        	arbi.comprobarjugada(nameJ,numJug);
	        	
	        }

	    
		
	}

}
