package org.zsh.dockertravisgradle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zsh.dockertravisgradle.model.Product;

import java.util.List;

@Repository
public interface ProductRepositoryJPA extends JpaRepository<Product, Long> {
        List<Product> findByName( String name);
        List<Product> findByPrice( Double price);
}
