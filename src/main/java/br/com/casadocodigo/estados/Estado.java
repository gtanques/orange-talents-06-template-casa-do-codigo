package br.com.casadocodigo.estados;

import br.com.casadocodigo.paises.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @ManyToOne
    @NotNull
    private Pais pais;

    @Deprecated
    private Estado() {
    }

    public Estado(@NotBlank @NotNull String nome, @NotNull @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

}
