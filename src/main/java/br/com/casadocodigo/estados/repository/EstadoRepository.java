package br.com.casadocodigo.estados.repository;

import br.com.casadocodigo.estados.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
