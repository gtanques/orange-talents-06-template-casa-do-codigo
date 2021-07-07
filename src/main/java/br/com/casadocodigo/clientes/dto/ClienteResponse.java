package br.com.casadocodigo.clientes.dto;

import br.com.casadocodigo.clientes.Cliente;

public class ClienteResponse {

    private Long id;

    @Deprecated
    private ClienteResponse() {
    }

    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }

}
