package br.com.graphql.resource;

import br.com.graphql.model.Cliente;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class QueryResource implements GraphQLQueryResolver {

    public String hello(){
        return "Hello GraphQL";
    }

    public Integer soma(Integer a, Integer b){
        return a + b;
    }

    public Cliente cliente(){
        return new Cliente("Victor", "victormacedo400@gmail.com");
    }

    public List<Cliente> clientes(){
        List<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            clientes.add(new Cliente(String.format("Cliente %s",i), String.format("email%s.com.br",i)));
        }
        return clientes;
    }
}
