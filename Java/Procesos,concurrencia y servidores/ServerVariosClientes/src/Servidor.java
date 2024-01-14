import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor
{

    public static void main(String[] args) throws IOException {

        try (ServerSocket server = new ServerSocket(80)) {

            while (true) { //No nos importa que el server se quede ejecutando siempre
                System.out.println("Escuchando...");
                Socket cliente = server.accept();
                System.out.println("Cliente conectado");
                HiloServer hCliente = new HiloServer(cliente);
                hCliente.start();

            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
