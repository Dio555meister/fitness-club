package chechov.fitnesclub.clientservice.repository;

import chechov.fitnesclub.clientservice.entity.ClientBuy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientBuyRepository extends JpaRepository<ClientBuy, UUID> {
}
