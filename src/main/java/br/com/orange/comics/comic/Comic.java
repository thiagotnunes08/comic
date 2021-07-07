package br.com.orange.comics.comic;

import br.com.orange.comics.usuario.Usuario;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.DayOfWeek;

import static br.com.orange.comics.comic.DiaDesconto.*;

@Entity
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String idComic;
    private String titulo;
    private BigDecimal preco;
    private String isbn;
    @Column(length = 500)
    private String descricao;
    @Column(length = 500)
    private String autores;
    @ManyToOne
    private Usuario usuario;
    private DiaDesconto diaDesconto;
    private boolean descontoAtivo = false;

    public Comic(String idComic, String titulo, BigDecimal preco, String isbn, String descricao, String autores,
                 Usuario usuario) {
        this.idComic = idComic;
        this.titulo = titulo;
        this.preco = preco;
        this.isbn = isbn;
        this.descricao = descricao;
        this.autores = autores;
        this.usuario = usuario;
        this.diaDesconto = this.setDiaSemana();
    }

    /**
     * @deprecated = construtor adicionado por conta do Hibernate
     */
    @Deprecated(since = "1.0")
    public Comic() {
        //construtor adicionado por conta do Hibernate
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

    public Usuario getUsuario() {
        return usuario;
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

    private DiaDesconto setDiaSemana() {
        var ultimoDigito = Long.parseLong(String.valueOf(this.isbn).substring(String.valueOf(this.isbn).length() - 1));

        if (ultimoDigito == 0 || ultimoDigito == 1) {
            return SEGUNDA_FEIRA;
        }
        if (ultimoDigito == 2 || ultimoDigito == 3) {
            return TERCA_FEIRA;
        }
        if (ultimoDigito == 4 || ultimoDigito == 5) {
            return QUARTA_FEIRA;
        }
        if (ultimoDigito == 6 || ultimoDigito == 7) {
            return QUINTA_FEIRA;
        }
        if (ultimoDigito == 8 || ultimoDigito == 9) {
            return SEXTA_FEIRA;
        } else return null;
    }

    public void atualizaDescontoAtivo(DayOfWeek diaHoje) {
        var diaDescontoHoje = DiaDesconto.converteDia(diaHoje);
        if (diaDescontoHoje == null) {
            this.descontoAtivo = false;
        } else {
            this.descontoAtivo = this.diaDesconto.equals(diaDescontoHoje);
        }
    }

}
