package ec.edu.utm.Help_Desk_api.controller;

import ec.edu.utm.Help_Desk_api.model.HistorialTicket;
import ec.edu.utm.Help_Desk_api.repository.HistorialRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial")
public class HistorialController {

    private final HistorialRepository repository;

    public HistorialController(HistorialRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<HistorialTicket> listar() {
        return repository.findAll();
    }

    @PostMapping
    public HistorialTicket guardar(@RequestBody HistorialTicket historial) {
        return repository.save(historial);
    }

    @PutMapping("/{id}")
    public HistorialTicket actualizar(@PathVariable Long id,
                                      @RequestBody HistorialTicket nuevoHistorial) {

        HistorialTicket historial = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));

        historial.setEstadoAnterior(nuevoHistorial.getEstadoAnterior());
        historial.setEstadoNuevo(nuevoHistorial.getEstadoNuevo());
        historial.setComentario(nuevoHistorial.getComentario());

        return repository.save(historial);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}