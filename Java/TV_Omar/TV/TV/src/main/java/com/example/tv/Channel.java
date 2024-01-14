package com.example.tv;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.net.URL;

public class Channel {

    public IntegerProperty id = new SimpleIntegerProperty(0);
    public StringProperty nombre = new SimpleStringProperty("");
    public StringProperty url = new SimpleStringProperty("");
    public StringProperty logo = new SimpleStringProperty("");

    public Channel(int id, String nombre, String url, String logo) {
        this.id.set(id);
        this.nombre.set(nombre);
        this.url.set(url);
        this.logo.set(logo);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getUrl() {
        return url.get();
    }

    public StringProperty urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public String getLogo() {
        return logo.get();
    }

    public StringProperty logoProperty() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo.set(logo);
    }
}
