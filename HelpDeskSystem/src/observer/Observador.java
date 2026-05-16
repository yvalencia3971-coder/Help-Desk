package observer;

public interface Observador {

    void actualizar(String mensaje);
}
class Tecnico implements Observador {
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Nuevo incidente: " + mensaje);
    }
}
