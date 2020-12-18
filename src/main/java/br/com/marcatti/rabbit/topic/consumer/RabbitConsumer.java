package br.com.marcatti.rabbit.topic.consumer;

import br.com.marcatti.rabbit.config.RabbitConfig;
import br.com.marcatti.rabbit.dto.Dto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitConsumer {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void  consumer(String msg) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Dto dto = mapper.readValue(msg, Dto.class);
            log.debug("consumer id {}  msg {}", dto.getMsg(), dto.getId());
        } catch (JsonProcessingException e) {
            log.error("Problema ao converter objeto {} ", msg);
        }
    }
}
