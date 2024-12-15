package chechov.fitnesclub.clientservice.service;

import chechov.fitnesclub.clientservice.dto.ClientBuyDto;
import chechov.fitnesclub.clientservice.entity.Client;
import chechov.fitnesclub.clientservice.entity.ClientBuy;
import chechov.fitnesclub.clientservice.mapper.ClientBuyMapper;
import chechov.fitnesclub.clientservice.repository.ClientBuyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientBuyService {
    private final ClientBuyRepository clientBuyRepository;
    private final ClientBuyMapper clientBuyMapper;


    @Transactional
    public UUID createClientBuy(ClientBuyDto clientBuyDto) {
        ClientBuy save = clientBuyRepository.save(clientBuyMapper.toEntity(clientBuyDto));
        log.info("Покупка с id{} успешно создана", clientBuyDto);
        return save.getId();
    }

    @Transactional(readOnly = true)
    public ClientBuyDto getClientBuy(UUID id) {
        ClientBuy clientBuy = getClientBuyOrThrow(id);
        log.info("Покупка с id{} успешно получена", id);
        return clientBuyMapper.toDto(clientBuy);
    }

    @Transactional(readOnly = true)
    public List<ClientBuyDto> getAllClientBuy() {
        List<ClientBuy> all = clientBuyRepository.findAll();
        log.info("Получен список всех покупок");
        return all.stream().map(clientBuyMapper::toDto)
                .toList();
    }

    @Transactional
    public ClientBuyDto updateClientBuy(UUID id, ClientBuyDto clientBuyDto) {
        ClientBuy clientBuy = getClientBuyOrThrow(id);
        log.info("Клиентская покупка с id{} успешно получена ", id);
        clientBuy.setClient(Client.builder().id(clientBuyDto.getClientId()).build());
        clientBuy.setPaymentId(clientBuyDto.getPaymentId());
        clientBuy.setAmount(clientBuyDto.getAmount());
        clientBuy.setBuyDate(clientBuyDto.getBuyDate());

        return clientBuyMapper.toDto(clientBuy);
    }

    @Transactional
    public void deleteClientBuy(UUID id) {
        clientBuyRepository.deleteById(id);
        log.info("Клиент с id {} был удален", id);
    }

    private ClientBuy getClientBuyOrThrow(UUID id) {
        return clientBuyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
