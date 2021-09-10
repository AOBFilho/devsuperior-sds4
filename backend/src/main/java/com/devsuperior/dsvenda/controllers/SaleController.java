package com.devsuperior.dsvenda.controllers;

import com.devsuperior.dsvenda.dto.SaleDTO;
import com.devsuperior.dsvenda.dto.SuccessSaleDTO;
import com.devsuperior.dsvenda.dto.SumSaleDTO;
import com.devsuperior.dsvenda.services.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    private SaleService service;

    public SaleController(SaleService service){ this.service = service; }

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping(value = "/success-sale")
    public ResponseEntity<List<SuccessSaleDTO>> successSaleGroupBySeller(){
        return ResponseEntity.ok(service.successSaleGroupBySeller());
    }

    @GetMapping(value = "/amount-sale")
    public ResponseEntity<List<SumSaleDTO>> sumSaleGroupBySeller(){
        return ResponseEntity.ok(service.sumSaleGroupBySeller());
    }
}
