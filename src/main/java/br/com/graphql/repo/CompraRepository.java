package br.com.graphql.repo;

import br.com.graphql.model.Cliente;
import br.com.graphql.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findAllByCliente(Cliente cliente);
}
