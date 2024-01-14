package sumas;

import java.util.Iterator;

public class ObtenerSumas {
    private int May;
    private int Men;
    int num1 = 3;
    int num2 = 7;
    public ObtenerSumas(int May, int Men) {
    	
		this.May = May;
		this.Men = Men;
        
    }
 // Método para realizar la suma y actualizar May y Men
    public void realizarSuma() {
         num1 = May + 5;
         num2 = Men + 5;

        May = Math.max(num1, num2);
        Men = Math.min(num1, num2);
    }

    public int getMay() {
        return May;
    }

    public int getMen() {
        return Men;
    }
}