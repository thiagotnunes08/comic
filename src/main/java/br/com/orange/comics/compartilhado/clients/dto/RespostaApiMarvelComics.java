package br.com.orange.comics.compartilhado.clients.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RespostaApiMarvelComics {

    @JsonProperty("data")
    private DadosApiComics dadosApiComics;

    public DadosApiComics getDadosApi() {
        return dadosApiComics;
    }

    @Override
    public String toString() {
        return "RespostaApiMarvel{" +
                "dadosApi=" + dadosApiComics +
                '}';
    }

}