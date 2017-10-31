package com.camilagiraldo.agenda;

/**
 * Created by USER on 31/10/2017.
 */

public class User {

    private String id, libro, nombre, telefono;

    public User(String id, String libro, String nombre, String telefono) {
        this.id = id;
        this.libro = libro;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
