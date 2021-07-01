package br.com.casadocodigo.livros.controller;

import br.com.casadocodigo.livros.Livro;
import br.com.casadocodigo.livros.dto.LivroForm;
import br.com.casadocodigo.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;


    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> inserir(@Valid @RequestBody LivroForm form){
        Livro livro = form.toModel(entityManager);
        System.out.println(livro.toString());
        return ResponseEntity.ok().build();
    }
}
