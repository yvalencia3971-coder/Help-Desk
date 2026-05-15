package factory;

public class IncidenteFactory {

    public static Incidente crearIncidente(String tipo) {

        return switch (tipo.toLowerCase()) {
            case "red" -> new IncidenteRed();
            default -> null;
        };
    }
}