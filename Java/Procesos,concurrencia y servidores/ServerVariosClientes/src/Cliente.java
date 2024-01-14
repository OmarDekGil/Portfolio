import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {

        Socket socket = new Socket();
        String host = "localhost";
        int puerto = 80;
        InetSocketAddress address = new InetSocketAddress(host, puerto);

        try {
            socket.connect(address);//ESPERA
            System.out.println("Estamos conectados!");
            System.out.println("Escribe tu nombre: ");
            OutputStream oS = socket.getOutputStream();
            BufferedReader bfTeclado = new BufferedReader(new InputStreamReader(System.in));
            String name = bfTeclado.readLine();
            oS.write((name + "\n").getBytes());
            //oS.write("Juan".getBytes());

            //Leer la respuesta del servidor
            InputStream is = socket.getInputStream();
            BufferedReader bfServer = new BufferedReader(new InputStreamReader(is));
            System.out.println(bfServer.readLine());

                    //Cerrar
            bfServer.close();
            bfTeclado.close();
            is.close();
            oS.close();
            socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
