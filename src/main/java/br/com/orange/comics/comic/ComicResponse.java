package br.com.orange.comics.comic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ComicResponse {

    private final String idComic;
    private final String titulo;
    private final BigDecimal preco;
    private final String isbn;
    private final String descricao;
    private final String autores;
    private final String nomeUsuario;
    private final DiaDesconto diaDesconto;
    private final boolean descontoAtivo;

    public ComicResponse(Comic comic) {
        this.idComic = comic.getIdComic();
        this.titulo = comic.getTitulo();
        this.isbn = comic.getIsbn();
        this.descricao = comic.getDescricao();
        this.autores = comic.getAutores();
        this.nomeUsuario = comic.getUsuario().getNome();
        this.diaDesconto = comic.getDiaDesconto();
        this.descontoAtivo = comic.isDescontoAtivo();
        if (this.descontoAtivo) {
            this.preco = comic.getPreco().subtract(comic.getPreco().multiply(BigDecimal.valueOf(0.1))).setScale(2, RoundingMode.UP);
        } else this.preco = comic.getPreco();
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAutores() {
        return autores;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public DiaDesconto getDiaDesconto() {
        return diaDesconto;
    }

    public boolean isDescontoAtivo() {
        return descontoAtivo;
    }

    public String getIdComic() {
        return idComic;
    }
}
