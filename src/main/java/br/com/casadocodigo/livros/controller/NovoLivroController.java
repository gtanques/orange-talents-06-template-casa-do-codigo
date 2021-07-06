package br.com.casadocodigo.livros.controller;

import br.com.casadocodigo.livros.Livro;
import br.com.casadocodigo.livros.dto.LivroRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros/novo")
public class NovoLivroController {

    @PersistenceContext
    private final EntityManager entityManager;

    public NovoLivroController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> inserir(@Valid @RequestBody LivroRequest request){
        Livro livro = request.toModel(entityManager);
        entityManager.persist(livro);
        return ResponseEntity.ok().build();
    }

}
