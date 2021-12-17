package com.retodos.repository.crud;

import java.util.Optional;

import com.retodos.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Nelson
 */
public interface InterfaceUser extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);    
    
    //Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();
}
