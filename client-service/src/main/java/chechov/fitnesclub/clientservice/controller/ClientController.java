package chechov.fitnesclub.clientservice.controller;

import chechov.fitnesclub.clientservice.dto.ClientDto;
import chechov.fitnesclub.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public UUID createClient(@RequestBody ClientDto clientDto) {
        log.info("Пришел запрос на сохранение пользователя");
        return clientService.createClient(clientDto);
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable UUID id) {
        log.info("Пришел запрос на получение клиента с id{}", id);
        return clientService.getClient(id);
    }

    @GetMapping
    public List<ClientDto> getAllClient() {
        log.info("Пришел запрос на получение всех клиентов");
        return clientService.getAllClient();
    }

    @PutMapping("/{id}")
    public ClientDto updateClient(@PathVariable UUID id, @RequestBody ClientDto clientDto) {
        log.info("Пришел запрос на обновление клиента");
        return clientService.updateClient(id, clientDto);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable UUID id) {
        log.info("Пришел запрос на удаление клиента");
        clientService.deleteClient(id);
    }
}
