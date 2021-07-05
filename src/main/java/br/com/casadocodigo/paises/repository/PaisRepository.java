package br.com.casadocodigo.paises.repository;

import br.com.casadocodigo.paises.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}
