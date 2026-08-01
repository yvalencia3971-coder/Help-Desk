package ec.edu.utm.Help_Desk_api.model;

import jakarta.persistence.Entity;

@Entity
public class IncidenteHardware extends Incidente {

    private String equipoAfectado;


    public IncidenteHardware() {
        super();
    }


    public String getEquipoAfectado() {
        return equipoAfectado;
    }


    public void setEquipoAfectado(String equipoAfectado) {
        this.equipoAfectado = equipoAfectado;
    }
}