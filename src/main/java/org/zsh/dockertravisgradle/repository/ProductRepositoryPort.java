package org.zsh.dockertravisgradle.repository;

import org.springframework.stereotype.Repository;
import org.zsh.dockertravisgradle.model.Product;

import java.util.List;

@Repository
public interface ProductRepositoryPort {

    void save( Product product);
    void delete( Product product);

    List<Product> findAll();
    List<Product> findByName(String name);
    List<Product> findByPrice(Double price);
}
