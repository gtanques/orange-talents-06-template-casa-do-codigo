package br.com.casadocodigo.livros.repository;

import br.com.casadocodigo.livros.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
