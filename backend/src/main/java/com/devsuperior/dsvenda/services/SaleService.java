package com.devsuperior.dsvenda.services;

import com.devsuperior.dsvenda.dto.SaleDTO;
import com.devsuperior.dsvenda.dto.SellerDTO;
import com.devsuperior.dsvenda.repositories.SaleRepository;
import com.devsuperior.dsvenda.repositories.SellerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    private SaleRepository repository;

    public SaleService(SaleRepository repository){
        this.repository = repository;
    }

    public Page<SaleDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(sale -> new SaleDTO(sale));
    }
}
