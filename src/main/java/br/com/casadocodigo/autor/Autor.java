package br.com.casadocodigo.autor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "tb_autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Instant getInstante() {
        return instante;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor() {
    }

    public Autor(String nome, String email, String descricao, Instant instante) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.instante = instante;
    }
}
