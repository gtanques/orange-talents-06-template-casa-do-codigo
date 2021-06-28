package br.com.casadocodigo.autor.dto;

import br.com.casadocodigo.autor.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

public class AutorForm {
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    @NotBlank
    private Instant instante;

    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.instante = Instant.now();
    }

    public Autor converter(){
        Autor autor = new Autor(this.nome, this.email, this.descricao, this.instante);
        return autor;
    }
}