package chechov.fitnesclub.clientservice.service;

import chechov.fitnesclub.clientservice.dto.ClientDto;
import chechov.fitnesclub.clientservice.entity.Client;
import chechov.fitnesclub.clientservice.mapper.ClientMapper;
import chechov.fitnesclub.clientservice.repository.ClientRepository;
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
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Transactional
    public UUID createClient(ClientDto clientDto) {
        Client clientSave = clientRepository.save(clientMapper.toEntity(clientDto));
        log.info("Клиент с id = {} успешно сохранен", clientSave.getId());
        return clientSave.getId();
    }

    @Transactional(readOnly = true)
    public ClientDto getClient(UUID id) {
        Client client = findClientOrThrow(id);
        log.info("Пользователь с id {} был найден", id);
        return clientMapper.toDto(client);
    }

    @Transactional(readOnly = true)
    public List<ClientDto> getAllClient() {
        return clientRepository.findAll()
                .stream()
                .map(client -> clientMapper.toDto(client))
                .toList();
    }

    @Transactional
    public ClientDto updateClient(UUID id, ClientDto clientDto) {
        Client client = findClientOrThrow(id);
        client.setAddress(clientDto.getAddress());
        client.setBirthday(clientDto.getBirthday());
        client.setEmail(clientDto.getEmail());
        client.setLastname(clientDto.getLastname());
        client.setFirstname(client.getFirstname());
        client.setPhoneNumber(clientDto.getPhoneNumber());

        log.info("Пользователь с id {}  был успешно обновлен", id);
        return clientMapper.toDto(client);
    }

    @Transactional
    public void deleteClient(UUID id) {
       log.info("Клиент с id{} удален", id);
        clientRepository.deleteById(id);
    }

    private Client findClientOrThrow(UUID id) {
        return clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
