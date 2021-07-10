package br.com.graphql.resolver;

import br.com.graphql.model.Cliente;
import br.com.graphql.model.Compra;
import br.com.graphql.model.Produto;
import br.com.graphql.service.ClienteService;
import br.com.graphql.service.CompraService;
import br.com.graphql.service.ProdutoService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

    @Autowired
    private CompraService compraService;

    public List<Compra> getCompras(Cliente cliente){
        return compraService.findAllByCliente(cliente);
    }

}
