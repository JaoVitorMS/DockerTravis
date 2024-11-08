package org.zsh.dockertravisgradle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.zsh.dockertravisgradle.controller.ProductController;
import org.zsh.dockertravisgradle.dto.ProductDto;
import org.zsh.dockertravisgradle.service.ProductService;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarEstoque() {
        List<ProductDto> productList = Arrays.asList(new ProductDto("Product1", 10.0), new ProductDto("Product2", 20.0));
        when(productService.listAll()).thenReturn(productList);

        ResponseEntity<List<ProductDto>> response = productController.listarEstoque();

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(productList, response.getBody());
    }

    @Test
    public void testListarEstoquePorNome() {
        List<ProductDto> productList = Arrays.asList(new ProductDto("Product1", 10.0));
        when(productService.listByName("Product1")).thenReturn(productList);

        ResponseEntity<List<ProductDto>> response = productController.listarEstoquePorNome("Product1");

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(productList, response.getBody());
    }

    @Test
    public void testListarEstoquePorPreco() {
        List<ProductDto> productList = Arrays.asList(new ProductDto("Product1", 10.0));
        when(productService.listByPrice(10.0)).thenReturn(productList);

        ResponseEntity<List<ProductDto>> response = productController.listarEstoquePorPreco(10.0);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(productList, response.getBody());
    }

    @Test
    public void testCadastrar() {
        ProductDto productDto = new ProductDto("Product1", 10.0);
        doNothing().when(productService).salvarProduto(productDto);

        ResponseEntity<ProductDto> response = productController.cadastrar(productDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(productService, times(1)).salvarProduto(productDto);
    }

    @Test
    public void testDeletar() {
        ProductDto productDto = new ProductDto("Product1", 10.0);
        doNothing().when(productService).deletarProduto(productDto);

        ResponseEntity<ProductDto> response = productController.deletar(productDto);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        verify(productService, times(1)).deletarProduto(productDto);
    }
}