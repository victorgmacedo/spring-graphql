package br.com.graphql.service;

import br.com.graphql.inputs.ClienteInput;
import br.com.graphql.model.Cliente;
import br.com.graphql.repo.ClienteRepository;
import br.com.graphql.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Long id){
        return clienteRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void remove(Long id){
        clienteRepository.deleteById(id);
    }
}
