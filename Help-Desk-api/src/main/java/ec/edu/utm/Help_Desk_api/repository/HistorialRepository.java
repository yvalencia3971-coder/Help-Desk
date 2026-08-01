package ec.edu.utm.Help_Desk_api.repository;

import ec.edu.utm.Help_Desk_api.model.HistorialTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialRepository extends JpaRepository<HistorialTicket, Long> {

}