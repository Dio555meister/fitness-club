package chechov.fitnesclub.clientservice.service;

import chechov.fitnesclub.clientservice.dto.ClientVisitDto;
import chechov.fitnesclub.clientservice.entity.ClientVisit;
import chechov.fitnesclub.clientservice.mapper.ClientVisitMapper;
import chechov.fitnesclub.clientservice.repository.ClientVisitRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientVisitService {
    private final ClientVisitRepository clientVisitRepository;
    private final ClientVisitMapper clientVisitMapper;

    @Transactional
    public UUID createClientVisit(ClientVisitDto clientVisitDto) {
        ClientVisit saveClientVisit = clientVisitRepository.save(clientVisitMapper.toEntity(clientVisitDto));
        log.info("Визит клиента {} создан", clientVisitDto);
        return saveClientVisit.getId();
    }

    @Transactional(readOnly = true)
    public ClientVisitDto getClientVisit(UUID id) {
        ClientVisit clientVisitOrThrow = getClientVisitOrThrow(id);
        log.info("Получение визита клиента с id{}", id);
        return clientVisitMapper.toDto(clientVisitOrThrow);
    }

    @Transactional(readOnly = true)
    public List<ClientVisitDto> getAllClientVisits() {
        List<ClientVisit> all = clientVisitRepository.findAll();
        log.info("Получен список всех клиентских визитов");
        return all.stream().map(clientVisitMapper::toDto)
                .toList();
    }

    @Transactional
    public void deleteClientVisit(UUID id) {
        getClientVisitOrThrow(id);
        log.info("Визит клиента с id{} был удален", id);
    }

    private ClientVisit getClientVisitOrThrow(UUID id) {
        return clientVisitRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
