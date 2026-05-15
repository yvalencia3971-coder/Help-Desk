package controller;

import singleton.TicketManager;

public class TicketController {

    public void iniciarSistema() {

        TicketManager manager = TicketManager.getInstancia();

        manager.gestionarTicket();
    }
}
