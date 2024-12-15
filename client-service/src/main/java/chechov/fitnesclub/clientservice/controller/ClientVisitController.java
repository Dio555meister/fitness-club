package chechov.fitnesclub.clientservice.controller;

import chechov.fitnesclub.clientservice.dto.ClientVisitDto;
import chechov.fitnesclub.clientservice.service.ClientVisitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/client-visits")
public class ClientVisitController {
    private final ClientVisitService clientVisitService;

    @PostMapping
    public UUID createClientVisit(@RequestParam ClientVisitDto clientVisitDto) {
        log.info("Пришел запрос на создание визита клиента {}", clientVisitDto);
        return clientVisitService.createClientVisit(clientVisitDto);
    }

    @GetMapping("/{id}")
    public ClientVisitDto getClientVisit(@PathVariable UUID id) {
        log.info("Пришел запрос на получение визита клиента c id{}", id);
        return clientVisitService.getClientVisit(id);
    }

    @GetMapping
    public List<ClientVisitDto> getAllClientVisits() {
        log.info("Пришел запрос на получение всех визитов клиентов");
        return clientVisitService.getAllClientVisits();
    }

    @DeleteMapping("/{id}")
    public void deleteClientVisit(@PathVariable UUID id) {
        log.info("ПРишел запрос на удаление визита клиента с id{}", id);
    }
}
