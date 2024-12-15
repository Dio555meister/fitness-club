package chechov.fitnesclub.clientservice.repository;

import chechov.fitnesclub.clientservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
