package br.com.casadocodigo.autores;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "tb_autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique=true)
    private String email;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false, updatable = false)
    private Instant instante = Instant.now();

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Instant getInstante() {
        return instante;
    }

    @Deprecated
    private Autor() {
    }

    public Autor(@NotBlank @NotNull String nome, @NotBlank @Email @NotNull String email, @NotNull @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

}
