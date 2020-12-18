package br.com.marcatti.rabbit.service;

import br.com.marcatti.rabbit.dto.Dto;
import br.com.marcatti.rabbit.topic.producer.RabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRabbit {

    @Autowired
    RabbitProducer rabbitProducer;

    public void send( Dto dto){
        rabbitProducer.rabbitSend(dto);
    }
}
