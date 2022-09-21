package com.hahoho87.stock_service.facade;

import org.springframework.stereotype.Service;

import com.hahoho87.stock_service.service.OptimisticLockStockService;

@Service
public class OptimisticLockStockFacade {

	private final OptimisticLockStockService stockService;

	public OptimisticLockStockFacade(OptimisticLockStockService stockService) {
		this.stockService = stockService;
	}

	public void decrease(Long id, Long quantity) throws InterruptedException {
		while (true) {
			try {
				stockService.decrease(id, quantity);
				break;
			} catch (Exception e) {
				Thread.sleep(50);
			}
		}
	}
}
