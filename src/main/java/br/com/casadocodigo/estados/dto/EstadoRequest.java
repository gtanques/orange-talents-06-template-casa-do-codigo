package br.com.casadocodigo.estados.dto;

import br.com.casadocodigo.configuracao.validacao.annotation.estado.EstadoRelacionamento;
import br.com.casadocodigo.configuracao.validacao.annotation.estado.EstadoValid;
import br.com.casadocodigo.configuracao.validacao.annotation.existe.ExisteValid;
import br.com.casadocodigo.estados.Estado;
import br.com.casadocodigo.paises.Pais;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;


@EstadoValid
public class EstadoRequest implements EstadoRelacionamento<String, Long> {

    @NotBlank
    private String nome;

    @ExisteValid(classe = Pais.class, atributo = "id")
    private Long paisId;

    @Deprecated
    private EstadoRequest() {
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public EstadoRequest(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, this.paisId);
        System.out.println(pais.toString());
        return new Estado(this.nome, pais);
    }

    @Override
    public String getCampo() {
        return nome;
    }

    @Override
    public Long getRelacionamento() {
        return paisId;
    }

}
