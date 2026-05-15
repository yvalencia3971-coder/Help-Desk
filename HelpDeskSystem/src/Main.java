import controller.TicketController;
import factory.Incidente;
import factory.IncidenteFactory;
import view.ConsolaView;

public class Main {

    public static void main(String[] args) {

        ConsolaView vista = new ConsolaView();
        vista.mostrarMenu();

        TicketController controller = new TicketController();
        controller.iniciarSistema();

        Incidente incidente = IncidenteFactory.crearIncidente("red");

        if(incidente != null) {
            incidente.procesar();
        }
    }
}