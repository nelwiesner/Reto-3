package com.retodos.service;

import java.util.List;
import java.util.Optional;

import com.retodos.model.Chocolate;
import com.retodos.repositorys.ChocolateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nelson
 */
@Service
public class ChocolateService {
    
    @Autowired
    private ChocolateRepository repository;

    public List<Chocolate> getAll() {
        return repository.getAll();
    }

    public Optional<Chocolate> getClothe(String reference) {
        return repository.getClothe(reference);
    }

    public Chocolate create(Chocolate product) {
        if (product.getReference() == null) {
            return product;
        } else {
            return repository.create(product);
        }
    }

    public Chocolate update(Chocolate product) {

        if (product.getReference() != null) {
            Optional<Chocolate> productDb = repository.getClothe(product.getReference());
            if (!productDb.isEmpty()) {
                
                if (product.getReference()!= null) {
                    productDb.get().setReference(product.getReference());
                }
                
                if (product.getCategory() != null) {
                    productDb.get().setCategory(product.getCategory());
                }
                
                if (product.getDescription() != null) {
                    productDb.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    productDb.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    productDb.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    productDb.get().setPhotography(product.getPhotography());
                }
                productDb.get().setAvailability(product.isAvailability());
                repository.update(productDb.get());
                return productDb.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(product -> {
            repository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}