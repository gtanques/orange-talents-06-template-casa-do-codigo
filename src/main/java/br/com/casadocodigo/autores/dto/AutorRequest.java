package br.com.casadocodigo.autores.dto;

import br.com.casadocodigo.autores.Autor;
import br.com.casadocodigo.configuracao.validacao.annotation.unico.UnicoValid;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;

    @UnicoValid(classe = Autor.class, atributo = "email")
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }

}
