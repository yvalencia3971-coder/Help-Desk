package model;

public class Usuario {

    private int id;
    private String nombre;
    private String correo;

    public Usuario(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public void mostrarUsuario() {
        System.out.println(nombre + " - " + correo);
    }
}