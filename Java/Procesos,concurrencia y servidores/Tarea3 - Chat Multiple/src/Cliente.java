import java.io.*;
import java.net.*;

public class Cliente {
    private ObjectOutputStream outputStream;

    public void iniciar() {

        try {
            Socket socketCliente = new Socket("localhost", 12345);
            outputStream = new ObjectOutputStream(socketCliente.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print("Ingrese su nombre: ");
                String nombre = reader.readLine();

                System.out.print("Ingrese su mensaje: ");
                String mensaje = reader.readLine();

                Mensaje mensajeObj = new Mensaje(nombre, mensaje);
                outputStream.writeObject(mensajeObj);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Cliente().iniciar();
    }
}
