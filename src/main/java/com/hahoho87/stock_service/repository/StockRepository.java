package com.hahoho87.stock_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hahoho87.stock_service.domain.Stock;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from Stock s where s.id = :id")
    Stock findByIdPessimisticLock(Long id);
}
