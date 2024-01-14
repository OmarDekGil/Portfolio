package sumas;

import java.io.FileWriter;
import java.io.IOException;

public class LanzarSumas {
    public static void main(String[] args) {
        int Max = 7;
        int Min = 3;
        
        ObtenerSumas sum = new ObtenerSumas(Max, Min);
try {
	for (int i = 1; i <= 500; i++) {
            Max = sum.getMay();
            Min = sum.getMen();
            
            int resultadoSuma = suma(Max, Min);
            
            // Realizar la suma después de obtener los nuevos valores
            sum.realizarSuma();
            String archivo = "..\\ProcesosSumas\\sumas" + i + ".txt";
            String resultado = Integer.toString(resultadoSuma);
            guardarArchivos(archivo, resultado);
            System.out.println(i + " " + Max + "  +-+" + resultadoSuma + "+-+ " + Min);
        }
}catch (Exception e) {
	System.out.println("No hecho");
}
        
    }

    // Método para realizar la suma de los números interiores
    static int suma(int man, int min) {
    	
        int suma = 0;
        for (int j = min; j <= man; j++) {
            suma += j;
            //System.out.println(suma);
        }
        return suma;
    }
 // Método para guardar un texto en un archivo
    static void guardarArchivos(String nombreArchivo, String texto) throws IOException {
        FileWriter writer = new FileWriter(nombreArchivo, true);
        writer.write(texto + "\n");
        writer.close();
    }
}



