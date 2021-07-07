package br.com.casadocodigo.estados.controller;

import br.com.casadocodigo.estados.Estado;
import br.com.casadocodigo.estados.dto.RequestGenerico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @PersistenceContext
    private EntityManager entityManager;

    public EstadoController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> inserir(@Valid @RequestBody RequestGenerico request){
        Estado estado = request.toModel(entityManager);
        System.out.println(estado.toString());
        entityManager.persist(estado);
        return ResponseEntity.ok().build();
    }

}
