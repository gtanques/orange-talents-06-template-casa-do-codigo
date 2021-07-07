package br.com.casadocodigo.clientes;

import br.com.casadocodigo.estados.Estado;
import br.com.casadocodigo.paises.Pais;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String documento;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String cidade;

    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;


    public Cliente(@NotBlank @NotNull String nome,
                   @NotBlank @NotNull String sobrenome,
                   @NotBlank @Email String email,
                   @NotBlank @NotNull String documento,
                   @NotBlank @NotNull String telefone,
                   @NotBlank @NotNull String cep,
                   @NotBlank @NotNull String endereco,
                   @NotBlank @NotNull String complemento,
                   @NotBlank @NotNull String cidade,
                   @NotNull Pais pais,
                   @NotNull Estado estado) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

}
