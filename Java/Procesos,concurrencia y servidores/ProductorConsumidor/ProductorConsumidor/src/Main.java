public class Main {
    public static void main(String[] args) {

        /*

        Cola colaComun = new Cola(false);
        Productor p = new Productor("Productor", colaComun);
        Consumidor c = new Consumidor("Consumidor", colaComun);

        p.start();
        c.start();
        */
        Cola colaComun = new Cola(false);
        for (int i = 0; i < 10; i++) {
            String aux = String.valueOf(i);
            Productor p = new Productor(aux, colaComun);
            Consumidor c = new Consumidor("Consumidor Nº" + i, colaComun);

            p.start();
            c.start();
        }

    }
}