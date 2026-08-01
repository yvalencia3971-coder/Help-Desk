package ec.edu.utm.Help_Desk_api.service;

import ec.edu.utm.Help_Desk_api.model.Usuario;
import ec.edu.utm.Help_Desk_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }


    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }


    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}