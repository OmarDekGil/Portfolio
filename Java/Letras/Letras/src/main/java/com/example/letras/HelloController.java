package com.example.letras;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.converter.NumberStringConverter;

import java.util.ArrayList;

public class HelloController {
    @FXML
    public Label letra1;
    @FXML
    public Label letra2;
    @FXML
    public Label letra3;
    @FXML
    public Label letra4;
    @FXML
    public Label letra5;
    @FXML
    public Label letra6;
    @FXML
    public Label letra7;
    @FXML
    public Label letra8;
    @FXML
    public Label letra9;
    @FXML
    public TextField Player1;
    @FXML
    public Label puntos1;
    @FXML
    public Button Btn1;
    @FXML
    public TextField Player2;
    @FXML
    public Label puntos2;
    @FXML
    public Button Btn2;
    @FXML
    public Button btnVocal;
    @FXML
    public Button btnConso;
    @FXML
    public Label Contador;
    public HBox Hbox;
    public Label mensaje;


    @FXML
    HelloLetras cyl = HelloLetras.instancia;


    @FXML
    private ArrayList<Labeled> labels = new ArrayList<Labeled>();
    public void initialize(){
        int i = 0;
       // var iterator = cyl.letras.listIterator().next();
        for (Node cifra : Hbox.getChildren()){
            var cifraLabel = (Label) cifra;

            Bindings.bindBidirectional(cifraLabel.textProperty(), cyl.letras.get(i++));
        }
        Bindings.bindBidirectional(Player1.textProperty(), cyl.player1);
        Bindings.bindBidirectional(Player2.textProperty(), cyl.player2);
        Bindings.bindBidirectional(puntos1.textProperty(), cyl.puntos1);
        Bindings.bindBidirectional(puntos2.textProperty(), cyl.puntos2);
        Bindings.bindBidirectional(mensaje.textProperty(), cyl.mensaje);
        Bindings.bindBidirectional(Contador.textProperty(), cyl.contador, new NumberStringConverter());
        cyl.setControl(this);
        Btn1.setDisable(true);
        Btn2.setDisable(true);
        Player1.setEditable(false);
        Player2.setEditable(false);
        cyl.init();
    }


    public void lanzaPalabra2(ActionEvent actionEvent) {
    cyl.lanzar2();
    Btn2.setDisable(true);
    }
    public void lanzaPalabra1(ActionEvent actionEvent) {
        cyl.lanzar1();
        Btn1.setDisable(false);

    }
    public void genvocal(ActionEvent actionEvent) {
        cyl.genvocal();
    }
    public void genconso(ActionEvent actionEvent) {
    cyl.genconso();
    }

}
