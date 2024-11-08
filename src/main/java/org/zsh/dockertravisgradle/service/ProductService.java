package org.zsh.dockertravisgradle.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.zsh.dockertravisgradle.dto.Mapper;
import org.zsh.dockertravisgradle.dto.ProductDto;
import org.zsh.dockertravisgradle.model.Product;
import org.zsh.dockertravisgradle.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private Mapper mapper;

    public void salvarProduto ( ProductDto productDto ) {
        Product product = mapper.toEntity( productDto );
        productRepository.save(product);
    }

    public void deletarProduto ( ProductDto productDto) {
        Product product = mapper.toEntity( productDto );
        productRepository.delete(product);
    }

    public List<ProductDto> listAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> mapper.toDto( product ))
                .toList();
    }

    public List<ProductDto> listByName ( String name ) {
        List<Product> products = productRepository.findByName( name );
        return products.stream()
                .map(product -> mapper.toDto(product))
                .toList();
    }

    public List<ProductDto> listByPrice ( double price ) {
        List<Product> products = productRepository.findByPrice( price );
        return products.stream()
                .map(product -> mapper.toDto(product))
                .toList();
    }
}
