package ec.edu.utm.Help_Desk_api.model;

import jakarta.persistence.Entity;

@Entity
public class IncidenteSoftware extends Incidente {

    private String nombreSoftware;


    public IncidenteSoftware() {
        super();
    }


    public String getNombreSoftware() {
        return nombreSoftware;
    }


    public void setNombreSoftware(String nombreSoftware) {
        this.nombreSoftware = nombreSoftware;
    }
}