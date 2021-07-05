package br.com.casadocodigo.paises.controller;

import br.com.casadocodigo.paises.Pais;
import br.com.casadocodigo.paises.dto.PaisRequest;
import br.com.casadocodigo.paises.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    PaisRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> inserir(@Valid @RequestBody PaisRequest request){
        Pais pais = request.toModel();
        repository.save(pais);
        return ResponseEntity.ok().build();
    }

}
