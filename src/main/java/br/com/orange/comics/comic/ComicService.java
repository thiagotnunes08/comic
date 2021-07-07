package br.com.orange.comics.comic;

import br.com.orange.comics.compartilhado.clients.MarvelClient;
import br.com.orange.comics.compartilhado.clients.dto.NomesAutores;
import br.com.orange.comics.compartilhado.clients.dto.RespostaApiMarvelComics;
import br.com.orange.comics.usuario.Usuario;
import br.com.orange.comics.usuario.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ComicService {

    private final ComicRepository comicRepository;
    private final MarvelClient marvelClient;
    private final UsuarioService usuarioService;

    public ComicService(ComicRepository comicRepository, MarvelClient marvelClient, UsuarioService usuarioService) {
        this.comicRepository = comicRepository;
        this.marvelClient = marvelClient;
        this.usuarioService = usuarioService;
    }


    public void preparaESalva(NovoComicRequest request, Long idUsuario) {
        var usuario = buscaUsuario(idUsuario);

        var marvelComicsResponse = marvelClient.buscaComic(request.getIdComic());

        var novoComic = this.toComic(marvelComicsResponse, usuario, request.getIdComic());

        comicRepository.save(novoComic);
    }


    public List<ComicResponse> preparaEBusca(Long idUsuario) {
        var usuario = buscaUsuario(idUsuario);
        var listaComic = comicRepository.findAllByUsuario(usuario);

        var diaHoje = LocalDate.now().getDayOfWeek();
        listaComic.forEach(comic -> comic.atualizaDescontoAtivo(diaHoje));

        return listaComic.stream().map(ComicResponse::new).collect(Collectors.toList());
    }


    private Usuario buscaUsuario(Long idUsuario) {
        return usuarioService.findById(idUsuario)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuário não encontrado"));
    }

    private Comic toComic(RespostaApiMarvelComics marvelComicsResponse, Usuario usuario, String idComic) {
        var comicsApiResponse = marvelComicsResponse.getDadosApi().getResposta().get(0);

        return new Comic(idComic, comicsApiResponse.getTitulo(),
                comicsApiResponse.getPrecos().get(0).getPreco(),
                comicsApiResponse.getIsbn(),
                comicsApiResponse.getDescricao(),
                comicsApiResponse.getAutoresComics().getNomesAutores()
                        .stream().map(NomesAutores::getNomeAutor).collect(Collectors.joining(", ")),
                usuario);
    }
}
