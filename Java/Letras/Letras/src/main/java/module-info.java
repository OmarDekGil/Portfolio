module com.example.letras {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.letras to javafx.fxml;
    exports com.example.letras;
}