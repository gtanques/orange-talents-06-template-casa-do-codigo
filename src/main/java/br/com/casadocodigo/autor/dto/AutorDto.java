package br.com.casadocodigo.autor.dto;

import br.com.casadocodigo.autor.Autor;

import java.time.Instant;

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
