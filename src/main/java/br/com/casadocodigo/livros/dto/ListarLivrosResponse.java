package br.com.casadocodigo.livros.dto;

import br.com.casadocodigo.livros.Livro;
import org.springframework.data.domain.Page;

public class ListarLivrosResponse {

    private Long id;
    private String titulo;

    @Deprecated
    private ListarLivrosResponse() {
    }

    public ListarLivrosResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static Page<ListarLivrosResponse> toDto(Page<Livro> livros){
        return livros.map(ListarLivrosResponse::new);
    }

}
