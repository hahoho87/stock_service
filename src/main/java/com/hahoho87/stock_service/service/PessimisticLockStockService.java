package com.hahoho87.stock_service.service;

import com.hahoho87.stock_service.domain.Stock;
import com.hahoho87.stock_service.repository.StockRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PessimisticLockStockService {

    private final StockRepository stockRepository;

    public PessimisticLockStockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrease(Long id, Long quantity) {
        Stock stock = stockRepository.findByIdPessimisticLock(id);
        stock.decrease(quantity);
        stockRepository.saveAndFlush(stock);
    }
}
