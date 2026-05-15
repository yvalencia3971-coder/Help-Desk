package singleton;

public class TicketManager {

    private static TicketManager instancia;

    private TicketManager() {
    }

    public static TicketManager getInstancia() {

        if(instancia == null) {
            instancia = new TicketManager();
        }

        return instancia;
    }

    public void gestionarTicket() {
        System.out.println("Gestionando tickets...");
    }
}