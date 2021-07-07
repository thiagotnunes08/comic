package br.com.orange.comics.compartilhado.clients.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Precos {

    @JsonProperty("price")
    private BigDecimal preco;

    public BigDecimal getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Precos{" +
                "preco=" + preco +
                '}';
    }
}
