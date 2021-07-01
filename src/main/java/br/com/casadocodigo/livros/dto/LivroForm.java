package br.com.casadocodigo.livros.dto;

import br.com.casadocodigo.autores.Autor;
import br.com.casadocodigo.categorias.Categoria;
import br.com.casadocodigo.configuracao.validacao.annotation.UnicoValid;
import br.com.casadocodigo.livros.Livro;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroForm {

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
    private String isbn;

    @JsonFormat(pattern = "dd/MM/yyy", shape = JsonFormat.Shape.STRING)
    @Future
    private LocalDate dataPublicacao;

    @NotNull
    private Long autorId;

    @NotNull
    private Long categoriaId;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public LivroForm(
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

        Assert.state(autor != null, "Autor não cadastrado!");
        Assert.state(categoria != null, "Autor não cadastrado!");

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
