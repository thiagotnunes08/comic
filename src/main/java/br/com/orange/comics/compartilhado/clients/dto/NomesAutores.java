package br.com.orange.comics.compartilhado.clients.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NomesAutores {

    @JsonProperty("name")
    private String nomeAutor;

    public String getNomeAutor() {
        return nomeAutor;
    }

    @Override
    public String toString() {
        return "NomesAutores{" +
                "nomeAutor='" + nomeAutor + '\'' +
                '}';
    }
}
