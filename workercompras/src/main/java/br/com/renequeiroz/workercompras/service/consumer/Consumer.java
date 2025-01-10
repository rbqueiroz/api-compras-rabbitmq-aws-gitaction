package br.com.renequeiroz.workercompras.service.consumer;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.renequeiroz.workercompras.model.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class Consumer {

    private final ObjectMapper mapper;
    //private final EmailService emailService;

    @RabbitListener(queues = {"${queue.name}"})
    public void consumer(@Payload Message message) throws IOException {
        var pedido = mapper.readValue(message.getBody(), Pedido.class);
        log.info("Pedido recebido: {}", pedido);
        //emailService.notificarCliente(pedido);
    }

}