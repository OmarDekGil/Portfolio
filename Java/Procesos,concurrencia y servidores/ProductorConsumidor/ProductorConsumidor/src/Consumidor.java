public class Consumidor extends Thread{

    String name;
    Cola colaComun;

    public Consumidor(String name, Cola colaComun) {
        this.name = name;
        this.colaComun = colaComun;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            int servCogido = colaComun.getIdServicio(name);
            //System.out.println(name + " coge el servicio Nº: " + servCogido);

        }

    }
}
