package br.com.orange.comics.comic;

import br.com.orange.comics.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComicRepository extends JpaRepository<Comic, Long> {
    List<Comic> findAllByUsuario(Usuario usuario);
}
