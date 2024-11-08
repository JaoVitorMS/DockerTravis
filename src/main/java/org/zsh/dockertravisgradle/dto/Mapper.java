package org.zsh.dockertravisgradle.dto;

import org.springframework.stereotype.Component;
import org.zsh.dockertravisgradle.model.Product;

@Component
public class Mapper {

    public ProductDto toDto( Product product) {
        ProductDto dto = new ProductDto(
                product.getName(),
                product.getPrice()
        );
        return dto;
    }

    public Product toEntity( ProductDto dto) {
        Product product = new Product(
                dto.name(),
                dto.price()
        );
        return product;
    }
}
