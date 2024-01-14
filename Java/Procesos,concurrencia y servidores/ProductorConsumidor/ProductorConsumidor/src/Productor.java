import java.util.Random;

public class Productor extends Thread{

    String name;
    Cola colaComun;

    public Productor(String name, Cola colaComun) {
        this.name = name;
        this.colaComun = colaComun;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            int mSegs = rnd.nextInt(500);
            try {
                Thread.sleep(mSegs);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //System.out.println(name + " pone en la cola: " + (i+1));
            int aux = Integer.parseInt(name);
            colaComun.setIdServicio(name,aux * 5 + i + 1);
        }
    }
}
