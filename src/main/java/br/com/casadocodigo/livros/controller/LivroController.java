package br.com.casadocodigo.livros.controller;

import br.com.casadocodigo.livros.Livro;
import br.com.casadocodigo.livros.dto.DetalheLivroResponse;
import br.com.casadocodigo.livros.dto.ListarLivrosResponse;
import br.com.casadocodigo.livros.dto.LivroRequest;
import br.com.casadocodigo.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;


    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> inserir(@Valid @RequestBody LivroRequest request){
        Livro livro = request.toModel(entityManager);
        repository.save(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> buscarLivros(@RequestParam(required = false) @PageableDefault(sort="id") Pageable paginacao){
        Page<Livro> livros = repository.findAll(paginacao);
        return ResponseEntity.ok().body(ListarLivrosResponse.toDto(livros));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhesLivro(@PathVariable Long id){
        Optional<Livro> optional =  repository.findById(id);
        if (optional.isPresent()){
            return ResponseEntity.ok(new DetalheLivroResponse(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
