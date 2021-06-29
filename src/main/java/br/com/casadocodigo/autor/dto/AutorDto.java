package br.com.casadocodigo.autor.dto;

import br.com.casadocodigo.autor.Autor;

import java.time.Instant;

public class AutorDto {

    private String nome;
    private String email;
    private Instant instante;

    public String getNome() { return nome; }

    public String getEmail() {
        return email;
    }

    public Instant getInstante() {
        return instante;
    }

    public AutorDto() {
    }

    public AutorDto(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.instante = autor.getInstante();
    }
}
