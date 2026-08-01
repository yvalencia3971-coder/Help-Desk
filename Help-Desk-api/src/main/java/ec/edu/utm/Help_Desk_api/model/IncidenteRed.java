package ec.edu.utm.Help_Desk_api.model;

import jakarta.persistence.Entity;

@Entity
public class IncidenteRed extends Incidente {

    private String tipoConexion;


    public IncidenteRed() {
        super();
    }


    public String getTipoConexion() {
        return tipoConexion;
    }


    public void setTipoConexion(String tipoConexion) {
        this.tipoConexion = tipoConexion;
    }
}