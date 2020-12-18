package br.com.marcatti.rabbit.topic.producer;

import br.com.marcatti.rabbit.config.RabbitConfig;
import br.com.marcatti.rabbit.dto.Dto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void rabbitSend(Dto dto) {
        String msg = null;
        try {
            msg = new ObjectMapper().writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            log.error("Problemas ao converter objeto dto {}", dto );
        }
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "", msg);
    }
}
