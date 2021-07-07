package br.com.casadocodigo.clientes.dto;

import br.com.casadocodigo.clientes.Cliente;
import br.com.casadocodigo.configuracao.validacao.annotation.documento.CpfCnpjValid;
import br.com.casadocodigo.configuracao.validacao.annotation.existe.ExisteValid;
import br.com.casadocodigo.configuracao.validacao.annotation.unico.UnicoValid;
import br.com.casadocodigo.estados.Estado;
import br.com.casadocodigo.paises.Pais;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @NotBlank
    @NotNull
    private String nome;

    @NotBlank
    @NotNull
    private String sobrenome;

    @UnicoValid(classe = Cliente.class, atributo = "email")
    @Email
    @NotNull
    private String email;

    @UnicoValid(classe = Cliente.class, atributo = "documento")
    @CpfCnpjValid
    @NotBlank
    @NotNull
    private String documento;

    @NotBlank
    @NotNull
    private String telefone;

    @NotBlank
    @NotNull
    private String cep;

    @NotBlank
    @NotNull
    private String endereco;

    @NotBlank
    @NotNull
    private String complemento;

    @NotBlank
    @NotNull
    private String cidade;

    @NotNull
    @ExisteValid(classe = Pais.class, atributo = "id")
    private Long paisId;

    @NotNull
    @ExisteValid(classe = Estado.class, atributo = "id")
    private Long estadoId;

    @Deprecated
    private ClienteRequest() {
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ClienteRequest( String nome,
                           String sobrenome,
                           String email,
                           String documento,
                           String telefone,
                           String cep,
                           String endereco,
                           String complemento,
                           String cidade,
                           Long paisId,
                           Long estadoId) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
    }

    public Cliente toModel(EntityManager entityManager){
        Pais pais = entityManager.find(Pais.class, this.paisId);
        Estado estado = entityManager.find(Estado.class, this.estadoId);
        return new Cliente( this.nome,
        this.sobrenome,
        this.email,
        this.documento,
        this.telefone,
        this.cep,
        this.endereco,
        this.complemento,
        this.cidade,
        pais,
        estado);
    }

}
