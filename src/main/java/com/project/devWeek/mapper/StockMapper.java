package com.project.devWeek.mapper;

import com.project.devWeek.model.Stock;
import com.project.devWeek.model.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component //componente que o spring ira fazer a gerencia de instâncias
public class StockMapper {//faz o mapeamento de dados

    public Stock toEntity(StockDTO dto) {
        Stock stock = new Stock();
        stock.setId(dto.getId());
        stock.setName(dto.getName());
        stock.setPrice(dto.getPrice());
        stock.setVariation(dto.getVariation());
        stock.setDate(dto.getDate());

        return stock;
    }

    public StockDTO toDto(Stock stock) { /*
        traduz o que está na base de dados para um dto que será mostrado no response body
    */
        StockDTO dto = new StockDTO();

        dto.setId(stock.getId());
        dto.setName(stock.getName());
        dto.setPrice(stock.getPrice());
        dto.setVariation(stock.getVariation());
        dto.setDate(stock.getDate());

        return dto;
    }

    public List<StockDTO> toDto(List<Stock> listStock){
        return listStock.stream().map(this::toDto).collect(Collectors.toList());
    }
}
