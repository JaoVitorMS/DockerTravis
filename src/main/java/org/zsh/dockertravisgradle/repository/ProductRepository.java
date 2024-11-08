package org.zsh.dockertravisgradle.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.zsh.dockertravisgradle.model.Product;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProductRepository implements ProductRepositoryPort{

    private ProductRepositoryJPA productRepositoryJPA;

    @Override
    public void save ( Product product ) {
        productRepositoryJPA.save(product);
    }

    @Override
    public void delete ( Product product ) {
        productRepositoryJPA.delete(product);
    }

    @Override
    public List<Product> findAll () {
        return productRepositoryJPA.findAll();
    }

    @Override
    public List<Product> findByName ( String name ) {
        return productRepositoryJPA.findByName ( name );
    }

    @Override
    public List<Product> findByPrice ( double price ) {
        return productRepositoryJPA.findByPrice ( price );
    }
}
