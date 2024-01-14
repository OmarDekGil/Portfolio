package com.example.letras;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.util.Duration;

import java.util.Random;

public class HelloLetras {
    HelloController control;

    public static HelloLetras instancia = new HelloLetras();
    int tiempo1, tiempo2;
    //Array de Labels
    public String[] vocales = {"A", "E", "I", "O", "U"};
    public String[] consonantes = {"B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "Ñ", "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z"};
    public ObservableList<StringProperty> letras;
    Random rand;
    boolean todasCompletas = true;
    boolean palabraJug1 = false;
    boolean palabraJug2 = false;
    int aux = 0;
    int p1 =0;
    int p2= 0;
    // IntegerProperty para los puntos
    public StringProperty puntos1 = new SimpleStringProperty();
    public StringProperty mensaje = new SimpleStringProperty();
    public StringProperty puntos2 = new SimpleStringProperty();

    // StringProperty para los jugadores
    public StringProperty player1 = new SimpleStringProperty();
    public StringProperty player2 = new SimpleStringProperty();

    // IntegerProperty para el contador
    public IntegerProperty contador = new SimpleIntegerProperty(60);


    public Timeline timeline;
    public void setControl(HelloController control) {
        this.control = control;
    }
    public HelloLetras() {

        control = new HelloController();
        letras = FXCollections.observableArrayList();
        rand = new Random();
        //Guardamos los label en un array a la vez que le añadimos propiedades
        for (int i = 0; i < 9; i++) {
            letras.add(new SimpleStringProperty());
        }
    }

    public void init(){
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e-> {

            // Fase 2: Cuando el contador llega a 60, se deshabilitan los botones btnvocal y btnconso
                verificarLabel();
            if (verificarLabel()){
                contador.set(contador.get()-1);
                control.Player1.setEditable(true);
                control.Player2.setEditable(true);
                control.Btn1.setDisable(false);
                control.Btn2.setDisable(false);
                control.btnConso.setDisable(true);
                control.btnVocal.setDisable(true);

            }
            if ((contador.get() == 0) || (palabraJug1 && palabraJug2)) {
                mostrarGanador();
                timeline.stop();
                contador.set(0);
            }

        }));
        timeline.setCycleCount(60);

        timeline.play();
        minusculas();
    }

    public void genvocal(){
        int j = 0;
        for (StringProperty label : letras) {
            if (label.get() == null || label.get().isEmpty()) {

                int i = rand.nextInt(vocales.length);
                letras.get(j).set(vocales[i]);
                label.set(vocales[i].toUpperCase());
                break;
            }
            j++;
        }
    }
    public void genconso(){
        int j = 0;
        for (StringProperty label : letras) {
            if (label.get() == null || label.get().isEmpty()) {

                int i = rand.nextInt(consonantes.length);
                letras.get(j).set(consonantes[i]);
                label.set(consonantes[i].toUpperCase());
                break;
            }
            j++;
        }
    }
    private boolean verificarLabel() {
        for (StringProperty label : letras) {
            if (label.get() == null) {
                return false;

            }
        }
        //control.Btn1.setDisable(true);
       // control.Btn2.setDisable(true);
        return true;
  }

 public void lanzar1() {
     if (!palabraJug1) {

         tiempo1  = contador.get();
        var rae = new RAE();
         try {
         String palabra = player1.get();
         palabra = palabra.toLowerCase();

         if (rae.comprobarPalabra(palabra)) {
             // La palabra existe en el diccionario
             minusculas();
             System.out.println(palabra);

             // Separar la palabra en letras
             char[] caracteres = palabra.toCharArray();
             boolean coincide = true;

             for (char letra : caracteres) {
                 String letraActual = String.valueOf(letra);
                 if (letraActual.matches("[a-z]")) {  // Verificar que es una letra
                     boolean letraCoincide = false;

                     for (int i = 0; i < letras.size(); i++) {
                         if (letraActual.equals(letras.get(i).get())) {
                             letraCoincide = true;
                             p1++;
                             puntos1.set("Puntos: " + p1);
                             break;  // Salir del bucle si la letra coincide
                         }
                     }

                     if (!letraCoincide) {
                         coincide = false;
                         break;  // Salir del bucle principal si una letra no coincide
                     }
                 }
             }

             if (coincide) {
                 // Todas las letras coinciden
                 puntos1.set("Puntos: " + p1);
             } else {
                 // Al menos una letra no coincide
                 puntos1.set("Incorrecto");
             }
         } else {
             // La palabra no existe en el diccionario
             puntos1.set("No existe");
         }
      } catch (Exception e) {
         throw new RuntimeException(e);
         }
         palabraJug1 = true;
     }


 }
    public void lanzar2() {
        if (!palabraJug2) {

                tiempo2 = contador.get();
             var rae = new RAE();
             try {
            String palabra = player2.get();
            palabra = palabra.toLowerCase();

            if (rae.comprobarPalabra(palabra)) {
                // La palabra existe en el diccionario
                minusculas();
                System.out.println(palabra);

                // Separar la palabra en letras
                char[] caracteres = palabra.toCharArray();
                boolean coincide = true;

                for (char letra : caracteres) {
                    String letraActual = String.valueOf(letra);
                    if (letraActual.matches("[a-z]")) {  // Verificar que es una letra
                        boolean letraCoincide = false;

                        for (int i = 0; i < letras.size(); i++) {
                            if (letraActual.equals(letras.get(i).get())) {
                                letraCoincide = true;
                                p2++;
                                puntos2.set("Puntos: " + p2);
                                break;  // Salir del bucle si la letra coincide
                            }
                        }

                        if (!letraCoincide) {
                            coincide = false;
                            break;  // Salir del bucle principal si una letra no coincide
                        }
                    }
                }

                if (coincide) {
                    // Todas las letras coinciden
                    puntos2.set("Puntos: " + p2);
                } else {
                    // Al menos una letra no coincide
                    puntos2.set("Incorrecto");
                }
            } else {
                // La palabra no existe en el diccionario
                puntos2.set("No existe");
            }
            } catch (Exception e) {
            throw new RuntimeException(e);
             }
            palabraJug2 = true;
        }


    }




    public void minusculas(){
        for (StringProperty letra : letras) {
            letra.addListener((obs, oldVal, newVal) -> {
                if (newVal != null) {
                    letra.set(newVal.toLowerCase());
                }
            });
        }
    }
    private void mostrarGanador() {



        String Mensaje="";

        if (p1 > p2) {
            Mensaje = "Ha ganado el jugador 1";
        }
        else if (p2>p1) {
            Mensaje = "Ha ganado el jugador 2";
        } else if (p1==p2 && tiempo1 > tiempo2) {
            Mensaje = "Ha ganado el jugador 1";

        }else{
            Mensaje = "Ha ganado el jugador 2";
        }
            mensaje.set(Mensaje);

    }
}






