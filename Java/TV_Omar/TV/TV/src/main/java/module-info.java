module com.example.tv {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.tv to javafx.fxml;
    exports com.example.tv;
}