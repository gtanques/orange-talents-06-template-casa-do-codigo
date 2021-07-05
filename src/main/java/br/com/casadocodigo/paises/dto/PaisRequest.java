package br.com.casadocodigo.paises.dto;

import br.com.casadocodigo.configuracao.validacao.annotation.unico.UnicoValid;
import br.com.casadocodigo.paises.Pais;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @UnicoValid(classe= Pais.class, atributo = "nome")
    @NotBlank
    private String nome;

    @Deprecated
    private PaisRequest() {
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PaisRequest(String nome) {
        this.nome = nome;
    }

    public Pais toModel(){
        return new Pais(this.nome);
    }

}
