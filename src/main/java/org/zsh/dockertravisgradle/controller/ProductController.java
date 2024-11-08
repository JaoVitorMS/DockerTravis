package org.zsh.dockertravisgradle.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zsh.dockertravisgradle.dto.ProductDto;
import org.zsh.dockertravisgradle.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/estoque")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/listar")
    public ResponseEntity<List<ProductDto>> listarEstoque() {
        List<ProductDto> estoque = productService.listAll();
        return new ResponseEntity<>(estoque, HttpStatus.ACCEPTED);
    }

    @GetMapping("/listarNome/{nome}")
    public ResponseEntity<List<ProductDto>> listarEstoquePorNome(@PathVariable String nome) {
        nome = nome.replaceAll("-", " ");
        List<ProductDto> productPerName = productService.listByName(nome);
        return new ResponseEntity<>(productPerName, HttpStatus.ACCEPTED);
    }

    @GetMapping("/listarPreco/{price}")
    public ResponseEntity<List<ProductDto>> listarEstoquePorPreco(@PathVariable Double price) {
        List<ProductDto> productPerPrice = productService.listByPrice(price);
        return new ResponseEntity<>(productPerPrice, HttpStatus.ACCEPTED);
    }
}
