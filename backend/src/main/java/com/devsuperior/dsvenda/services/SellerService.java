package com.devsuperior.dsvenda.services;

import com.devsuperior.dsvenda.dto.SellerDTO;
import com.devsuperior.dsvenda.entities.Seller;
import com.devsuperior.dsvenda.repositories.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    private SellerRepository repository;

    public SellerService(SellerRepository repository){
        this.repository = repository;
    }

    public List<SellerDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(seller -> new SellerDTO(seller))
                .collect(Collectors.toList());
    }
}
