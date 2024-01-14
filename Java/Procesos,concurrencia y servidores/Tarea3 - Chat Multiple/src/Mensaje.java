import java.io.Serializable;

public class Mensaje implements Serializable {
    private String userTalking;
    private String mensaje;

    public Mensaje(String userTalking, String mensaje) {
        this.userTalking = userTalking;
        this.mensaje = mensaje;
    }

    public String getUserTalking() {
        return userTalking;
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return userTalking + " dice: " + mensaje;
    }
}

