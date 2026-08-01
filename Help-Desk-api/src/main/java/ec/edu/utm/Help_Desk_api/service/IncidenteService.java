package ec.edu.utm.Help_Desk_api.service;

import ec.edu.utm.Help_Desk_api.model.Incidente;
import ec.edu.utm.Help_Desk_api.repository.IncidenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenteService {

    private final IncidenteRepository incidenteRepository;


    public IncidenteService(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }


    public List<Incidente> listarIncidentes() {
        return incidenteRepository.findAll();
    }


    public Incidente guardarIncidente(Incidente incidente) {
        return incidenteRepository.save(incidente);
    }


    public Incidente buscarIncidente(Long id) {
        return incidenteRepository.findById(id).orElse(null);
    }


    public void eliminarIncidente(Long id) {
        incidenteRepository.deleteById(id);
    }
}