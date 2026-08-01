package ec.edu.utm.Help_Desk_api.repository;

import ec.edu.utm.Help_Desk_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

}