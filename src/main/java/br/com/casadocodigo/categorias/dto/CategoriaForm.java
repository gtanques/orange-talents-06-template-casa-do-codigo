package br.com.casadocodigo.categorias.dto;

import br.com.casadocodigo.categorias.Categoria;
import br.com.casadocodigo.configuracao.validacao.annotation.UnicoValid;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @UnicoValid(classe = Categoria.class, atributo = "nome")
    @NotBlank
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    @Deprecated
    private CategoriaForm() {
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

}
