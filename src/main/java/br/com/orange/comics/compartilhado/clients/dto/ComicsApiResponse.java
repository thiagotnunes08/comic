package br.com.orange.comics.compartilhado.clients.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ComicsApiResponse {

    @JsonProperty("title")
    private String titulo;
    @JsonProperty("description")
    private String descricao;
    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("prices")
    private List<Precos> precos;
    @JsonProperty("creators")
    private AutoresComics autoresComics;

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<Precos> getPrecos() {
        return precos;
    }

    public AutoresComics getAutoresComics() {
        return autoresComics;
    }

    @Override
    public String toString() {
        return "ComicsResponse{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", isbn='" + isbn + '\'' +
                ", precos=" + precos +
                ", autoresComics=" + autoresComics +
                '}';
    }
}
