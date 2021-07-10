package br.com.graphql.service;

import br.com.graphql.model.Cliente;
import br.com.graphql.repo.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends DefaultService<Cliente>{

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        super(clienteRepository);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente getInstance() {
        return new Cliente();
    }
}
