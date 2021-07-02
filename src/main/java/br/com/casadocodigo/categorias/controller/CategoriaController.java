package br.com.casadocodigo.categorias.controller;

import br.com.casadocodigo.categorias.Categoria;
import br.com.casadocodigo.categorias.dto.CategoriaRequest;
import br.com.casadocodigo.categorias.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody @Valid CategoriaRequest request){
        Categoria categoria = request.toModel();
        repository.save(categoria);
        return  ResponseEntity.ok().build();
    }

}
