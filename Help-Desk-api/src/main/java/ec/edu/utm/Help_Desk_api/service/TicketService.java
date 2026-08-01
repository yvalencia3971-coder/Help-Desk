package ec.edu.utm.Help_Desk_api.service;

import ec.edu.utm.Help_Desk_api.model.Ticket;
import ec.edu.utm.Help_Desk_api.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;


    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    public List<Ticket> listarTickets() {
        return ticketRepository.findAll();
    }


    public Ticket guardarTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }


    public Ticket buscarTicket(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }


    public void eliminarTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}