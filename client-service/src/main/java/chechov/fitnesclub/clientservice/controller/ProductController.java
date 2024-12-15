package chechov.fitnesclub.clientservice.controller;

import chechov.fitnesclub.clientservice.dto.ProductDto;
import chechov.fitnesclub.clientservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public UUID createProduct(@RequestBody ProductDto productDto) {
        log.info("Получен запрос на создание товара");
        return productService.createProduct(productDto);
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable UUID id) {
        log.info("Пришел запрос на получение товара{}",id);
        return productService.getProduct(id);
    }

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam(name = "filter") String filterName) {
        log.info("Пришел запрос на получение всех товаров");
        return productService.getProducts();
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable UUID id, @RequestBody ProductDto productDto) {
        log.info("Пришел запрос на обновление продукта");
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        log.info("Пришел запрос на удаление товара");
    }
}
