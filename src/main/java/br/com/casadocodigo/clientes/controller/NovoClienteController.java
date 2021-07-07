package br.com.casadocodigo.clientes.controller;


import br.com.casadocodigo.clientes.Cliente;
import br.com.casadocodigo.clientes.dto.ClienteRequest;
import br.com.casadocodigo.clientes.dto.ClienteResponse;
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
@RequestMapping("/clientes/novo")
public class NovoClienteController {

    @PersistenceContext
    EntityManager entityManager;

    public NovoClienteController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @PostMapping
    @Transactional
    public ResponseEntity<ClienteResponse> inserir(@Valid @RequestBody ClienteRequest request){
        Cliente cliente = request.toModel(entityManager);
        entityManager.persist(cliente);

        return ResponseEntity.ok().body(new ClienteResponse(cliente));
    }

}
