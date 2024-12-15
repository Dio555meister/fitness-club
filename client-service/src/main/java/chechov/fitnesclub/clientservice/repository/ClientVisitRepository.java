package chechov.fitnesclub.clientservice.repository;

import chechov.fitnesclub.clientservice.entity.ClientVisit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientVisitRepository extends JpaRepository<ClientVisit, UUID> {
}
