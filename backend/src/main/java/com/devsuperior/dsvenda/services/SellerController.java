package com.devsuperior.dsvenda.services;

import com.devsuperior.dsvenda.dto.SellerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    private SellerService service;

    public SellerController(SellerService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<SellerDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
