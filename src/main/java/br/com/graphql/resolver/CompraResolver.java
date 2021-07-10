package br.com.graphql.resolver;

import br.com.graphql.model.Cliente;
import br.com.graphql.model.Compra;
import br.com.graphql.model.Produto;
import br.com.graphql.service.ClienteService;
import br.com.graphql.service.ProdutoService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public String status(Compra compra){
        return "Status: " + compra.getStatus();
    }

    public Cliente getCliente(Compra compra){
        return clienteService.findById(compra.getCliente().getId());
    }

    public Produto getProduto(Compra compra){
        return produtoService.findById(compra.getProduto().getId());
    }

}
