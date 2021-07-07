package br.com.orange.comics.compartilhado.clients.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AutoresComics {

    @JsonProperty("items")
    private List<NomesAutores> nomesAutores;

    public List<NomesAutores> getNomesAutores() {
        return nomesAutores;
    }

    @Override
    public String toString() {
        return "AutoresComics{" +
                "nomesAutores=" + nomesAutores +
                '}';
    }
}
