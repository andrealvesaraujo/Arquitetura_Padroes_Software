package br.cefetrj.lojaweb.service;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.cefetrj.lojaweb.domain.Produto;
import br.cefetrj.lojaweb.repositorios.ProdutoRepository;

/**
 * Service layer.
 * Specify transactional behavior and mainly
 * delegate calls to Repository.
 */
@Component
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public void add(Produto Produto) {
        produtoRepository.save(Produto);
    }

    @Transactional(readOnly=true)
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Transactional
    public void addAll(Collection<Produto> Produtos) {
        for (Produto Produto : Produtos) {
            produtoRepository.save(Produto);
        }
    }

    @Transactional(readOnly=true)
    public List<Produto> findByNameIs(String name) {
        return produtoRepository.findByNomeIs(name);
    }

    @Transactional(readOnly=true)
    public List<Produto> findByNomeContainingIgnoreCase(String searchString) {
        return produtoRepository.findByNomeContainingIgnoreCase(searchString);
    }
}