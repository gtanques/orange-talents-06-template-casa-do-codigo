package br.com.casadocodigo.categorias.dto;

import br.com.casadocodigo.categorias.Categoria;
import br.com.casadocodigo.configuracao.validacao.annotation.unico.UnicoValid;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @UnicoValid(classe = Categoria.class, atributo = "nome")
    @NotBlank
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    @Deprecated
    private CategoriaRequest() {
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

}
