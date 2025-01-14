package br.com.casadocodigo.livros.dto;

import br.com.casadocodigo.autores.Autor;
import br.com.casadocodigo.categorias.Categoria;
import br.com.casadocodigo.configuracao.validacao.annotation.existe.ExisteValid;
import br.com.casadocodigo.configuracao.validacao.annotation.unico.UnicoValid;
import br.com.casadocodigo.livros.Livro;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @UnicoValid(classe = Livro.class, atributo = "titulo")
    @NotBlank
    private String titulo;

    @Size(max = 500)
    @NotBlank
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @UnicoValid(classe = Livro.class, atributo = "isbn")
    private String isbn;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @ExisteValid(classe = Autor.class, atributo = "id")
    private Long autorId;

    @NotNull
    @ExisteValid(classe = Categoria.class, atributo = "id")
    private Long categoriaId;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public LivroRequest(
            String titulo, String resumo,
            String sumario, BigDecimal preco,
            Integer numeroPaginas, String isbn,
            LocalDate dataPublicacao, Long autorId,
            Long categoriaId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autorId = autorId;
        this.categoriaId = categoriaId;
    }

    public Livro toModel(EntityManager entityManager) {
        Autor autor = entityManager.find(Autor.class, this.autorId);
        Categoria categoria = entityManager.find(Categoria.class, this.categoriaId);
        return new Livro(
                this.titulo,
                this.resumo,
                this.sumario,
                this.preco,
                this.numeroPaginas,
                this.isbn,
                this.dataPublicacao,
                autor,
                categoria);
    }

}
