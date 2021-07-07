package br.com.orange.comics.compartilhado.clients.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DadosApiComics {

    @JsonProperty("results")
    private List<ComicsApiResponse> resposta;

    public List<ComicsApiResponse> getResposta() {
        return resposta;
    }

    @Override
    public String toString() {
        return "DadosApi{" +
                "resposta=" + resposta +
                '}';
    }
}
