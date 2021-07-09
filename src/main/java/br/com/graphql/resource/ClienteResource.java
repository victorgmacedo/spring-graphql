package br.com.graphql.resource;

import br.com.graphql.inputs.ClienteInput;
import br.com.graphql.model.Cliente;
import br.com.graphql.service.ClienteService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResource implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    public Cliente cliente(Long id){
        return clienteService.findById(id);
    }

    public List<Cliente> clientes(){
        return clienteService.findAll();
    }

    public Cliente save(ClienteInput clienteInput){
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteInput, cliente);
        return clienteService.save(cliente);
    }

    public Boolean delete(Long id){
        clienteService.remove(id);
        return true;
    }

}
