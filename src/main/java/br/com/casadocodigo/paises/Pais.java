package br.com.casadocodigo.paises;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="tb_pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String nome;

    @Deprecated
    private Pais() {
    }

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
