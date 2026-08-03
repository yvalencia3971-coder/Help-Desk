package ec.edu.utm.Help_Desk_api.controller;

import ec.edu.utm.Help_Desk_api.model.Ticket;
import ec.edu.utm.Help_Desk_api.repository.TicketRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {

    private final TicketRepository repository;

    public TicketController(TicketRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Ticket> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Ticket guardar(@RequestBody Ticket ticket) {
        return repository.save(ticket);
    }

    @PutMapping("/{id}")
    public Ticket actualizar(@PathVariable Long id, @RequestBody Ticket nuevoTicket) {

        Ticket ticket = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));

        ticket.setTitulo(nuevoTicket.getTitulo());
        ticket.setDescripcion(nuevoTicket.getDescripcion());
        ticket.setCategoria(nuevoTicket.getCategoria());
        ticket.setPrioridad(nuevoTicket.getPrioridad());
        ticket.setEstado(nuevoTicket.getEstado());

        return repository.save(ticket);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}