package com.retodos.web;

import java.util.List;
import java.util.Optional;

import com.retodos.model.Chocolate;
import com.retodos.service.ChocolateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nelson
 */
@RestController
@RequestMapping("/api/chocolate")
@CrossOrigin("*")
public class ChocolateController {
    
    @Autowired
    private ChocolateService chocolateService;

    @GetMapping("/all")
    public List<Chocolate> getAll() {
        return chocolateService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Chocolate> getClothe(@PathVariable("reference") String reference) {
        return chocolateService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Chocolate create(@RequestBody Chocolate product) {
        return chocolateService.create(product);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Chocolate update(@RequestBody Chocolate product) {
        return chocolateService.update(product);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return chocolateService.delete(reference);
    }
  
}
