package chechov.fitnesclub.clientservice.service;

import chechov.fitnesclub.clientservice.dto.ProductDto;
import chechov.fitnesclub.clientservice.entity.Product;
import chechov.fitnesclub.clientservice.mapper.ProductMapper;
import chechov.fitnesclub.clientservice.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public UUID createProduct(ProductDto productDto) {
        Product entity = productMapper.toEntity(productDto);
        Product product = productRepository.save(entity);
        log.info("Сохранение продукта прошло успешно");
        return product.getId();
    }

    @Transactional(readOnly = true)
    public ProductDto getProduct(UUID id) {
        Product product = getProductOrThrow(id);
        log.info("Товар был успешно найден");
        return productMapper.toDto(product);
    }

    @Transactional(readOnly = true)
    public List<ProductDto> getProducts() {
        List<Product> products = productRepository.findAll();
        log.info("Получен список всех товаров");
        return products.stream().map(productMapper::toDto).toList();
    }

    @Transactional
    public ProductDto updateProduct(UUID id, ProductDto productDto) {
        Product product = getProductOrThrow(id);
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        log.info("Товар был успешно обновлен");
        return productMapper.toDto(product);
    }

    @Transactional
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
        log.info("ТОвар был успешно удален");
    }

    private Product getProductOrThrow(UUID id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
