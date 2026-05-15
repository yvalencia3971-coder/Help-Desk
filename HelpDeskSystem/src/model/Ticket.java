package model;

public class Ticket {

    private int id;
    private String descripcion;
    private String estado;

    public Ticket(int id, String descripcion, String estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public void mostrarTicket() {
        System.out.println(id + " " + descripcion + " " + estado);
    }
}
