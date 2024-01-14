package advNum;


public class Arbitro {
int numAdv;
boolean finJuego = false;
boolean disponible;


public Arbitro(boolean disponible) {
	this.disponible=disponible;
	  numAdv = genNumAlt(1, 10);
	}
public static int genNumAlt(int rangoIni, int rangoFi) {
   
    int numeroAleatorio = rangoIni + (int) (Math.random() * (rangoFi - rangoIni + 1));

    return numeroAleatorio;
}
public synchronized void comprobarjugada(String name,int numero) {
	System.out.println(" "+name + " juega "+numero);
	
	if(numAdv == numero) {
		finJuego = true;
		System.out.println(" "+name+ " ha ganado");
	}else {	
		System.out.println("  Fallo");
		System.out.println("");
		notify();
	}
}

}
