package br.com.casadocodigo.autor.repository;

import br.com.casadocodigo.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
