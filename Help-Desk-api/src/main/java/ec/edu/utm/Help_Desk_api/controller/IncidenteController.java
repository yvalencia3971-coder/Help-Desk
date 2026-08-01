package ec.edu.utm.Help_Desk_api.controller;

import ec.edu.utm.Help_Desk_api.model.Incidente;
import ec.edu.utm.Help_Desk_api.service.IncidenteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/incidentes")
@CrossOrigin(origins = "*")
public class IncidenteController {


    private final IncidenteService incidenteService;


    public IncidenteController(IncidenteService incidenteService) {
        this.incidenteService = incidenteService;
    }


    @GetMapping
    public List<Incidente> listarIncidentes() {
        return incidenteService.listarIncidentes();
    }


    @PostMapping
    public Incidente crearIncidente(@RequestBody Incidente incidente) {
        return incidenteService.guardarIncidente(incidente);
    }


    @GetMapping("/{id}")
    public Incidente buscarIncidente(@PathVariable Long id) {
        return incidenteService.buscarIncidente(id);
    }


    @DeleteMapping("/{id}")
    public void eliminarIncidente(@PathVariable Long id) {
        incidenteService.eliminarIncidente(id);
    }

}