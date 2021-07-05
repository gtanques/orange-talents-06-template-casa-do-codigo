package br.com.casadocodigo.estados.dto;

import br.com.casadocodigo.configuracao.validacao.annotation.existe.ExisteValid;
import br.com.casadocodigo.configuracao.validacao.annotation.unico.UnicoValid;
import br.com.casadocodigo.estados.Estado;
import br.com.casadocodigo.paises.Pais;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class EstadoRequest {

    @NotBlank
    @UnicoValid(classe = Estado.class, atributo = "nome")
    private String nome;

    @ExisteValid(classe = Pais.class, atributo = "id")
    private Long pais_id;

    @Deprecated
    private EstadoRequest() {
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public EstadoRequest(String nome, Long pais_id) {
        this.nome = nome;
        this.pais_id = pais_id;
    }

    public Estado toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, this.pais_id);
        System.out.println(pais.toString());
        return new Estado(this.nome, pais);
    }

}
