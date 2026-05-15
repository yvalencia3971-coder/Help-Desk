package factory;

public class IncidenteRed extends Incidente {

    @Override
    public void procesar() {
        System.out.println("Procesando incidente de red");
    }
}
