package br.com.orange.comics.usuario;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private LocalDate dataNascimento;

    public Usuario(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    /**
     * @deprecated = construtor adicionado por conta do Hibernate
     */
    @Deprecated(since = "1.0")
    public Usuario() {
        //construtor adicionado por conta do Hibernate
    }

    public String getNome() {
        return nome;
    }
}
