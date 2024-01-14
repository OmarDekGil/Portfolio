package magicpoo;
import java.util.ArrayList;
import java.util.List;


public class Mazo {
	private  int Mac;
	private  int Atc;
	private int Defc;
	private int Numc;
	private  ArrayList<Mazo> cartas;
	

	
	
//////////////////////////////////////////////////////////////////
	public int getMac() {
		return Mac;
	}
	public void setMac(int mac) {
		Mac = mac;
	}
//////////////////////////////////////////////////////////////////
	public ArrayList<Mazo> getCartas() {
		return cartas;
	}
	public void setCartas(ArrayList<Mazo> cartas) {
		this.cartas = cartas;
	}
	
public Mazo() {
			Mac=numalt(1,5);
    		Atc=numalt(2,16);
    		Defc=numalt(1,5);
    		
		}
    	public Mazo(int Numc, int Mac,int Atc, int Defc ) {
    		this.Numc=Numc;
    		this.Mac=Mac;
    		this.Atc=Atc;
    		this.Defc=Defc;	
    } 
 
    /*	public void addStats(Mazo carta1) {
    		cartas.add(carta1);
    		
    	}*/
	

	@Override
		public String toString() {
			return "Mana= "+Mac+","+"Ataque= "+Atc+","+"Defensa= "+Defc+",";
		}

	public int getAtc() {
			return Atc;
		}

		public void setAtc(int atc) {
			Atc = atc;
		}

		public int getDefc() {
			return Defc;
		}

		public void setDefc(int defc) {
			Defc = defc;
		}


    public int getNumc() {
			return Numc;
		}

		public void setNumc(int numc) {
			Numc = numc;
		}

	int numalt(int min, int max){
        int x = (int) ((Math.random()*((max-min)+1))+min);
        return x;
    }




}
