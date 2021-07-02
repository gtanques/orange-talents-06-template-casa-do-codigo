package br.com.casadocodigo.categorias;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Deprecated
    private Categoria() {
    }

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
