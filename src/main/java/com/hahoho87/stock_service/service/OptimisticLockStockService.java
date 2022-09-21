package com.hahoho87.stock_service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hahoho87.stock_service.domain.Stock;
import com.hahoho87.stock_service.repository.StockRepository;

@Service
public class OptimisticLockStockService {

	private final StockRepository stockRepository;

	public OptimisticLockStockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	@Transactional
	public void decrease(Long id, Long quantity) {
		Stock stock = stockRepository.findByIdOptimisticLock(id);
		stock.decrease(quantity);
		stockRepository.saveAndFlush(stock);
	}
}
