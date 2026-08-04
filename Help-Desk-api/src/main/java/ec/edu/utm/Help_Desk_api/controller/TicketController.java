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


    // Obtener todos los tickets
    @GetMapping
    public List<Ticket> listar() {

        return repository.findAll();

    }



    // Guardar ticket
    @PostMapping
    public Ticket guardar(@RequestBody Ticket ticket) {

        return repository.save(ticket);

    }



    // Buscar ticket por id
    @GetMapping("/{id}")
    public Ticket buscar(@PathVariable Long id) {

        return repository.findById(id)
                .orElse(null);

    }



    // Actualizar ticket
    @PutMapping("/{id}")
    public Ticket actualizar(
            @PathVariable Long id,
            @RequestBody Ticket ticket) {


        ticket.setId(id);

        return repository.save(ticket);

    }



    // Eliminar ticket
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {

        repository.deleteById(id);

    }

}