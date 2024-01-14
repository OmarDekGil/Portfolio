import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    private List<ObjectOutputStream> clientes;

    public Servidor() {
        clientes = new ArrayList<>();
    }

    public void iniciar() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while (true) {
                System.out.println("Esperando conexiones...");
                Socket socketCliente = serverSocket.accept();
                System.out.println("Cliente conectado desde " + socketCliente.getInetAddress());

                ObjectOutputStream outputStream = new ObjectOutputStream(socketCliente.getOutputStream());
                clientes.add(outputStream);

                // Manejar cada conexión en un hilo separado
                Thread hilo = new Thread(new ManejadorCliente(socketCliente));
                hilo.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ManejadorCliente implements Runnable {
        private Socket socketCliente;
        private ObjectInputStream inputStream;

        public ManejadorCliente(Socket socketCliente) {
            this.socketCliente = socketCliente;
            try {
                this.inputStream = new ObjectInputStream(socketCliente.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Mensaje mensaje = (Mensaje) inputStream.readObject();
                    System.out.println("Mensaje recibido: " + mensaje);

                    // Enviar el mensaje a todos los clientes
                    for (ObjectOutputStream client : clientes) {
                        client.writeObject(mensaje);
                        client.flush();
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Servidor().iniciar();
    }
}

