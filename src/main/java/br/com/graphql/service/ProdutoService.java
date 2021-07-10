package br.com.graphql.service;

import br.com.graphql.model.Produto;
import br.com.graphql.repo.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends DefaultService<Produto>{

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        super(produtoRepository);
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto getInstance() {
        return new Produto();
    }
}
