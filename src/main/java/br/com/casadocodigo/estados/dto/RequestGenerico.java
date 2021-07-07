package br.com.casadocodigo.estados.dto;

import br.com.casadocodigo.configuracao.validacao.annotation.estado.RelacionamentoGenerico;
import br.com.casadocodigo.configuracao.validacao.annotation.estado.uniconopais.UnicoNoPaisValid;
import br.com.casadocodigo.configuracao.validacao.annotation.existe.ExisteValid;
import br.com.casadocodigo.estados.Estado;
import br.com.casadocodigo.paises.Pais;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@UnicoNoPaisValid
public class RequestGenerico implements RelacionamentoGenerico<String, Long> {

    @NotBlank
    @NotNull
    private String nome;

    @ExisteValid(classe = Pais.class, atributo = "id")
    @NotNull
    private Long paisId;

    @Deprecated
    private RequestGenerico() {
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RequestGenerico(String nome, Long paisId) {
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
