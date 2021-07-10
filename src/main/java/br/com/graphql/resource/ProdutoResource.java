package br.com.graphql.resource;

import br.com.graphql.inputs.ProdutoInput;
import br.com.graphql.model.Produto;
import br.com.graphql.service.ProdutoService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoResource implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProdutoService produtoService;

    public Produto produto(Long id){
        return produtoService.findById(id);
    }

    public List<Produto> produtos(){
        return produtoService.findAll();
    }

    public Produto salvarProduto(ProdutoInput produtoInput){
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoInput, produto);
        return produtoService.save(produto);
    }

    public Boolean deletarProduto(Long id){
        produtoService.remove(id);
        return true;
    }
}
