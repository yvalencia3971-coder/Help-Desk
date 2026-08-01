package ec.edu.utm.Help_Desk_api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class HistorialTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String estadoAnterior;

    private String estadoNuevo;

    private String comentario;

    private LocalDateTime fecha;


    @ManyToOne
    @JoinColumn(name="ticket_id")
    private Ticket ticket;



    public HistorialTicket(){

    }


    @PrePersist
    public void crearFecha(){
        fecha = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getEstadoAnterior() {
        return estadoAnterior;
    }


    public void setEstadoAnterior(String estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }


    public String getEstadoNuevo() {
        return estadoNuevo;
    }


    public void setEstadoNuevo(String estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }


    public String getComentario() {
        return comentario;
    }


    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    public LocalDateTime getFecha() {
        return fecha;
    }


    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


    public Ticket getTicket() {
        return ticket;
    }


    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}