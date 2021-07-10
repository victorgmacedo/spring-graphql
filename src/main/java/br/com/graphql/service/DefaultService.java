package br.com.graphql.service;

import br.com.graphql.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@AllArgsConstructor
public abstract class DefaultService<T> {

    private JpaRepository<T, Long> repository;

    public T findById(Long id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public List<T> findAll(PageRequest of) {
        return repository.findAll(of).getContent();
    }
    public List<T> findAll() {
        return repository.findAll();
    }

    public T save(T t) {
        return repository.save(t);
    }

    public void remove(Long id){
        repository.deleteById(id);
    }

    public abstract T getInstance();
}
