package br.com.orange.comics.comic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/usuario/{idUsuario}/comic")
public class ComicController {

    private final ComicService comicService;

    public ComicController(ComicService comicService) {
        this.comicService = comicService;
    }

    @PostMapping
    public ResponseEntity<String> cadastra(@RequestBody @Valid NovoComicRequest request, @PathVariable Long idUsuario) {
        comicService.preparaESalva(request, idUsuario);

        return ResponseEntity.status(CREATED).body("Comic criado");
    }

    @GetMapping
    public List<ComicResponse> lista(@PathVariable Long idUsuario) {
        return comicService.preparaEBusca(idUsuario);
    }
}
