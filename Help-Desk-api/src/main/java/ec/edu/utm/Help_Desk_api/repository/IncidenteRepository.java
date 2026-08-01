package ec.edu.utm.Help_Desk_api.repository;

import ec.edu.utm.Help_Desk_api.model.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Long> {

}