package magicpoo;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gamemanager {
 private    ArrayList<Mazo> cartas;

 public ArrayList<Mazo> getCartas() {
	return cartas;
}
public void setCartas(ArrayList<Mazo> cartas) {
	this.cartas = cartas;
}
public Mazo getCarta() {
	return mano;
}
public void setCarta(Mazo carta) {
	this.mano = carta;
}
static Scanner sc = new Scanner(System.in);
int NumC;
int robacarta=4;
private   Mazo mano;
  int selcarta;
 private int selModo=0;
 int Manaj=5;
 public int getSelModo() {
	return selModo;
}
public void setSelModo(int selModo) {
	this.selModo = selModo;
}
public  Gamemanager() {
	cartas = new ArrayList<Mazo>();
	  for (int i = 0; i < 4; i++) {
		mano = new Mazo();
	    cartas.add(i,mano);
	}
	

	

			
			
		
 }
 
 
public static void main(String[] args) {
	
	   Gamemanager game = new Gamemanager();
	    
	    
		int selmodo;
		boolean seguir = true;
		while (seguir) {
		System.out.println("");
		
		System.out.println("¿De que modo quieres jugar tus cartas?");
		System.out.println("0.Mostrar cartas | 1. Normal | 2.Overkill | 3.Tanque | 4.Quema | 5.Terminar partida");	
		selmodo=sc.nextInt();
		switch (selmodo) {
		case 0:
		game.mostrarCartas();	
			break;
		case 1:
		game.normal();
		game.robarcarta();
			break;
		case 2:
		game.overkill();
		game.robarcarta();
				break;
		case 3:
		game.tanque();
		game.robarcarta();
				break;
		case 4:
		game.quemacarta();
		game.robarcarta();
				break;
			
		default:System.out.println("Selecciona la opcion correcta");
			break;
		}
	
		}
		
	    
	}

 void mostrarCartas() {

for (int i = 1; i < cartas.size(); i++) {
	NumC=i;
		System.out.println("Carta "+NumC+". "+cartas.get(i));
	
}

 }
void robarcarta() {
	System.out.println("Robas una carta");
	mano = new Mazo();
	cartas.add(mano);
	
}
 
 
 void quemacarta() {
	System.out.println("¿Qué carta deseas borrar?");
	selcarta=sc.nextInt();
	cartas.remove(selcarta);
	System.out.println("Carta numero "+selcarta+" eliminada");
	robacarta--;
    
 }
void normal() {
	System.out.println("Tu mana: "+Manaj);
	System.out.println("¿Que carta quieres jugar?");
	selcarta=sc.nextInt();
	if (Manaj>=cartas.get(selcarta).getMac()) {
		Manaj=Manaj-cartas.get(selcarta).getMac();
		System.out.println(cartas.get(selcarta));
		
	  Manaj=Manaj+3;
	  
	  System.out.println("Mana restante: "+Manaj);
	}else {
		System.out.println("Tu mana ("+Manaj+") es inferior a el mana de tu carta ("+cartas.get(selcarta).getMac()+")");
	}
	
}

void tanque() {
	
}
 
 
 void overkill() {
	 System.out.println("Selecciona la carta que quieres jugar en modo Overkill");
	 selcarta=sc.nextInt();
	 if (Manaj>=cartas.get(selcarta).getMac()||cartas.get(selcarta).getDefc()!=1) {
		cartas.get(selcarta).getAtc();
	}if (Manaj<cartas.get(selcarta).getMac()) {
		System.out.println("No se puede ejecutar la carta en modo Overkill");
	}
 }
 
 
 
 
 
 
 public Mazo getMano() {
	return mano;
}
public void setMano(Mazo mano) {
	this.mano = mano;
}


 
 
}