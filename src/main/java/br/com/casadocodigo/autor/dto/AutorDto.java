package br.com.casadocodigo.autor.dto;

import br.com.casadocodigo.autor.Autor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Date;

public class AutorDto {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private Instant instante;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Instant getInstante() {
        return instante;
    }

    public AutorDto() {
    }

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.instante = autor.getInstante();
    }
}
