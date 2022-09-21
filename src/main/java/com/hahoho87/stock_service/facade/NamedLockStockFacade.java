package com.hahoho87.stock_service.facade;

import org.springframework.stereotype.Service;

import com.hahoho87.stock_service.repository.LockRepository;
import com.hahoho87.stock_service.service.StockService;

@Service
public class NamedLockStockFacade {

	private final LockRepository lockRepository;
	private final StockService stockService;

	public NamedLockStockFacade(LockRepository lockRepository, StockService stockService) {
		this.lockRepository = lockRepository;
		this.stockService = stockService;
	}

	public void decrease(Long id, Long quantity) {
		try {
			lockRepository.getLock(id.toString());
			stockService.decrease(id, quantity);
		} finally {
			lockRepository.releaseLock(id.toString());
		}
	}
}
