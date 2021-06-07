package com.project.devWeek.controller;

import com.project.devWeek.model.Stock;
import com.project.devWeek.model.dto.StockDTO;
import com.project.devWeek.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin //libera a consulta de uma requisição distinta, sem isso, no front end pode dar B.O
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired //controla quando vai ser instanciada ou não a camada services
    private StockService service; //liga o controller com a classe services

    //inserção uma ação
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.save(dto)); //metodo save, salvando os dados do dto
        //save deve atender a mesma resposta da ResponseEntity
    }

    //alteração de mais uma ação
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }

    //busca de todas as ações
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List <StockDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    //busca de um valor
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findTodayStocks(){
        return ResponseEntity.ok(service.findByToday());
    }

}
