package advNum;

public class Main {
	//public Arbitro arbi;
	
	public static void main(String[] args) {
		int idJ;
		
		Arbitro arbitro = new Arbitro(false);
		
		
		System.out.println("NÚMERO A ADIVINAR:" + arbitro.numAdv);
		while(arbitro.finJuego == false) {
			Jugador j1 = new Jugador("Jugador 1",arbitro);
		Jugador j2 = new Jugador("Jugador 2",arbitro);
		
		
		 j1.start();

         synchronized (arbitro) {
             try {
                 arbitro.wait();  // Esperar a que el primer jugador complete su jugada
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }

         j2.start();

         synchronized (arbitro) {
             try {
                 arbitro.wait();  // Esperar a que el segundo jugador complete su jugada
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
		}
	}
}
