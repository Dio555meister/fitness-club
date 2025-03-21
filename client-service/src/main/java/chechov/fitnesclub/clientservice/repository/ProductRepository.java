package chechov.fitnesclub.clientservice.repository;

import chechov.fitnesclub.clientservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
