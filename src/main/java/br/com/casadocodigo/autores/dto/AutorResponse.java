package br.com.casadocodigo.autores.dto;

import br.com.casadocodigo.autores.Autor;

import java.time.Instant;

public class AutorResponse {

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

    @Deprecated
    private AutorResponse() {
    }

    public AutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.instante = autor.getInstante();
    }

}
