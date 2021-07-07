package br.com.orange.comics.usuario;

import br.com.orange.comics.compartilhado.validators.CampoUnico;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class NovoUsuarioRequest {

    @NotBlank(message = "Nome deve ser peenchido")
    final String nome;

    @NotBlank(message = "Email deve ser peenchido")
    @Email(message = "Deve ser um Email bem formado")
    @CampoUnico(fieldName = "email", domainClass = Usuario.class, message = "Email já cadastrado")
    final String email;

    @NotBlank(message = "CPF deve ser peenchido")
    @CPF(message = "Deve ser um CPF bem formado")
    @CampoUnico(fieldName = "cpf", domainClass = Usuario.class, message = "CPF já cadastrado")
    final String cpf;

    @NotNull(message = "Data de nascimento deve ser peenchida")
    final LocalDate dataNascimento;

    public NovoUsuarioRequest(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

}
