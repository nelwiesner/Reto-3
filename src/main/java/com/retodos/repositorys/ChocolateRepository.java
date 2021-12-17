package com.retodos.repositorys;

import java.util.List;
import java.util.Optional;

import com.retodos.model.Chocolate;
import com.retodos.repository.crud.InterfaceChocolate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Nelson
 */
@Repository
public class ChocolateRepository {
    @Autowired
    private InterfaceChocolate repository;

    public List<Chocolate> getAll() {
        return repository.findAll();
    }
    public Optional<Chocolate> getClothe(String reference) {
        return repository.findById(reference);
    }
    
    public Chocolate create(Chocolate clothe) {
        return repository.save(clothe);
    }

    public void update(Chocolate clothe) {
        repository.save(clothe);
    }
    
    public void delete(Chocolate clothe) {
        repository.delete(clothe);
    }
}
