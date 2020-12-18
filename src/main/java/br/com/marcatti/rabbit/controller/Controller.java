package br.com.marcatti.rabbit.controller;

import br.com.marcatti.rabbit.dto.Dto;
import br.com.marcatti.rabbit.service.ServiceRabbit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1")
public class Controller {

    @Autowired
    ServiceRabbit service;

    @PostMapping
    public ResponseEntity<String> sendToRabbit(@RequestBody Dto dto){
        log.debug("sendToRabbit Dto {}" , dto);
        service.send(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }}
