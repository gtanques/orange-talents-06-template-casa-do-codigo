package br.com.casadocodigo.livros;

import br.com.casadocodigo.autores.Autor;
import br.com.casadocodigo.categorias.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false)
    private String resumo;

    @Column(nullable = false)
    private String sumario;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Integer numeroPaginas;

    @Column(nullable = false, unique = true)
    private String isbn;

    @JsonFormat(pattern = "dd/MM/yyy", shape = Shape.STRING)
    @NotNull
    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @ManyToOne
    private Autor autorId;

    @NotNull
    @ManyToOne
    private Categoria categoriaId;

    @Deprecated
    private Livro() {
    }

    public Livro(@NotBlank String titulo,
                 @NotBlank @Size(max = 500) String resumo,
                 @NotBlank String sumario,
                 @NotNull BigDecimal preco,
                 @NotNull @Min(100) Integer numeroPaginas,
                 @NotBlank String isbn,
                 @NotNull @Future LocalDate dataPublicacao,
                 @NotNull Autor autorId,
                 @NotNull Categoria categoriaId) {
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

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Autor getAutorId() {
        return autorId;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

}
