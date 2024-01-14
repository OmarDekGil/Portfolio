public class Cola {
    //Productor deja los productos / servicios
    //Consumidor los coge
    int idServicio;
    boolean disponible;

    public Cola(boolean disponible) {
        this.disponible = disponible;
    }

    synchronized public int getIdServicio(String name) {
        while (!disponible){
            try {
                wait(); //<<------------ Se espera a que le notifiquen
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        disponible = false;
        System.out.println(name + " coge el servicio Nº: " + idServicio);
        //notify();
        notifyAll(); //<<<---- Notifica a todos los demas hilos en espera
        return idServicio;
    }

    synchronized public void setIdServicio(String name, int idServicio) {
        while (disponible){
            try {
                wait(); //<<------------ Se espera a que le notifiquen
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Productor Nº" + name + " pone en la cola: " + idServicio);
        this.idServicio = idServicio;
        disponible = true;
        //notify(); //<<<--- Aviso de que podéis dejar de esperar
        notifyAll();
    }
}
