package br.com.orange.comics.usuario;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salva(NovoUsuarioRequest request) {
        usuarioRepository.save(this.toUsuario(request));
    }

    public Optional<Usuario> findById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }
    private Usuario toUsuario(NovoUsuarioRequest request) {
        return new Usuario(request.nome, request.email, request.cpf, request.dataNascimento);
    }
}
