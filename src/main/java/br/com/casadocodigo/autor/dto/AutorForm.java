package br.com.casadocodigo.autor.dto;

import br.com.casadocodigo.autor.Autor;
import br.com.casadocodigo.autor.validacao.EmailDuplicadoValid;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {
    @NotBlank
    private String nome;

    @EmailDuplicadoValid
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter(){
        return new Autor(this.nome, this.email, this.descricao);
    }
}
