package com.devsuperior.dsvenda.dto;

import com.devsuperior.dsvenda.entities.Sale;

import java.time.LocalDate;

public class SaleDTO {
    private Long id;
    private Integer visited;
    private Integer deals;
    private Double amount;
    private LocalDate date;
    private SellerDTO seller;

    public SaleDTO(){}

    public SaleDTO(Long id, Integer visited, Integer deals, Double amount, LocalDate date, SellerDTO seller) {
        this.id = id;
        this.visited = visited;
        this.deals = deals;
        this.amount = amount;
        this.date = date;
        this.seller = seller;
    }

    public SaleDTO(Sale sale) {
        this.id = sale.getId();
        this.visited = sale.getVisited();
        this.deals = sale.getDeals();
        this.amount = sale.getAmount();
        this.date = sale.getDate();
        this.seller = new SellerDTO(sale.getSeller());
    }

    public Long getId() {
        return id;
    }

    public Integer getVisited() {
        return visited;
    }

    public Integer getDeals() {
        return deals;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public SellerDTO getSeller() {
        return seller;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVisited(Integer visited) {
        this.visited = visited;
    }

    public void setDeals(Integer deals) {
        this.deals = deals;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSeller(SellerDTO seller) {
        this.seller = seller;
    }
}
