package com.hahoho87.stock_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hahoho87.stock_service.domain.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
