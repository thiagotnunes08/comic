package br.com.orange.comics.compartilhado.clients;

import br.com.orange.comics.compartilhado.clients.dto.RespostaApiMarvelComics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "marvel", url = "http://gateway.marvel.com/")
public interface MarvelClient {

     String KEY = "?ts=1&apikey=d30be1d5018ed42443b9302d3b214751&hash=e1672a179a1f5f1291ad5b96e8d8be18";

    @GetMapping("/v1/public/comics/{comicId}" + KEY)
    RespostaApiMarvelComics buscaComic(@PathVariable String comicId);

}
