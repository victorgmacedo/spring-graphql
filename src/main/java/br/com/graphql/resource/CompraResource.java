package br.com.graphql.resource;

import br.com.graphql.inputs.CompraInput;
import br.com.graphql.model.Cliente;
import br.com.graphql.model.Compra;
import br.com.graphql.model.Produto;
import br.com.graphql.service.CompraService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompraResource implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CompraService compraService;

    public Compra compra(Long id){
        return compraService.findById(id);
    }

    public List<Compra> compras(int page, int size){
        return compraService.findAll(PageRequest.of(page, size));
    }

    public Compra salvarCompra(CompraInput compraInput){
        Compra compra = new Compra();
        BeanUtils.copyProperties(compraInput, compra);
        compra.setCliente(new Cliente(compraInput.getClienteId()));
        compra.setProduto(new Produto(compraInput.getProdutoId()));
        return compraService.save(compra);
    }

    public Boolean deletarCompra(Long id){
        compraService.remove(id);
        return true;
    }
}
