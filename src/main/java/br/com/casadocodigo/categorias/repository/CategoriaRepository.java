package br.com.casadocodigo.categorias.repository;

import br.com.casadocodigo.categorias.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String request);
}
