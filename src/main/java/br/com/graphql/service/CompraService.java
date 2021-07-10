package br.com.graphql.service;

import br.com.graphql.model.Cliente;
import br.com.graphql.model.Compra;
import br.com.graphql.repo.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService extends DefaultService<Compra>{

    private CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        super(compraRepository);
        this.compraRepository = compraRepository;
    }

    @Override
    public Compra getInstance() {
        return new Compra();
    }

    public List<Compra> findAllByCliente(Cliente cliente) {
        return compraRepository.findAllByCliente(cliente);
    }
}
