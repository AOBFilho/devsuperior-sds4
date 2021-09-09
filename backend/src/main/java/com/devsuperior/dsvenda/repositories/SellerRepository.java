package com.devsuperior.dsvenda.repositories;

import com.devsuperior.dsvenda.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {
}
