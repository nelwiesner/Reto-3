package com.retodos.repository.crud;

import com.retodos.model.Chocolate;

import org.springframework.data.mongodb.repository.MongoRepository;


/**
 *
 * @author Nelson
 */
public interface InterfaceChocolate extends MongoRepository<Chocolate, String>{
    
}
