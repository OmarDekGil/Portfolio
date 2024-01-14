import java.io.*;
import java.net.Socket;

public class HiloServer extends Thread{

    Socket cliente;
    OutputStream oS;
    InputStream iS;
    BufferedReader bf;

    public HiloServer(Socket cliente) {
        this.cliente = cliente;

    }

    @Override
    public void run() {
        super.run();
        try {
            iS = cliente.getInputStream();//Canal de flujo de entrada
            oS = cliente.getOutputStream();//Canal de flujo de salida
            bf = new BufferedReader(new InputStreamReader(iS));//Para leer la entrada
            //Lectura
            String userName = bf.readLine();
            //Escritura
            oS.write(("Bienvenido, " + userName).getBytes());

            oS.close();
            iS.close();
            bf.close();
            cliente.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
