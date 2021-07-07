package br.com.orange.comics.comic;

import javax.validation.constraints.NotBlank;

public class NovoComicRequest {

    @NotBlank(message = "IdComic deve ser preenchido")
    private String idComic;

    public String getIdComic() {
        return idComic;
    }

}
