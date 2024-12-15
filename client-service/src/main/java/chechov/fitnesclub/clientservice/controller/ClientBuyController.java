package chechov.fitnesclub.clientservice.controller;

import chechov.fitnesclub.clientservice.dto.ClientBuyDto;
import chechov.fitnesclub.clientservice.dto.ClientDto;
import chechov.fitnesclub.clientservice.service.ClientBuyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/client-buys")
public class ClientBuyController {
    private final ClientBuyService clientBuyService;

    @PostMapping
    public UUID createClientBuy(ClientBuyDto clientBuyDto) {
        log.info("Пришел запрос на создание товара с id{}", clientBuyDto);
        return clientBuyService.createClientBuy(clientBuyDto);
    }

    @GetMapping("/{id}")
    public ClientBuyDto getClientBuy(@PathVariable UUID id) {
        log.info("Пришел запрос на получение товара с id{}", id);
        return clientBuyService.getClientBuy(id);
    }

    @GetMapping
    public List<ClientBuyDto> getAllClientBuy() {
        log.info("Пришел запрос на получение списка всех товаров");
        return clientBuyService.getAllClientBuy();
    }

    @PutMapping("/{id}")
    public ClientBuyDto updateClientBuy(@PathVariable UUID id, @RequestBody ClientBuyDto clientBuyDto) {
        log.info("Пришел запрос на обновление клиентской покупки");
        return clientBuyService.updateClientBuy(id, clientBuyDto);
    }

    @DeleteMapping("/{id}")
    public void deleteClientBuy(@PathVariable UUID id) {
        log.info("Пришел запрос на удаление пользователя");
    }
}
