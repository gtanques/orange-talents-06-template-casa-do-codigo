package br.com.casadocodigo.autores.controller;

import br.com.casadocodigo.autores.Autor;
import br.com.casadocodigo.autores.dto.AutorResponse;
import br.com.casadocodigo.autores.dto.AutorRequest;
import br.com.casadocodigo.autores.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private final AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AutorResponse> inserir(@RequestBody @Valid AutorRequest request){
        Autor autor = request.toModel();
        repository.save(autor);
        return ResponseEntity.ok().body(new AutorResponse(autor));
    }
}
