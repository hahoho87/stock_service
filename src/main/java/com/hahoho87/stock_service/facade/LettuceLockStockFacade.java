package com.hahoho87.stock_service.facade;

import org.springframework.stereotype.Component;

import com.hahoho87.stock_service.repository.RedisLockRepository;
import com.hahoho87.stock_service.service.StockService;

@Component
public class LettuceLockStockFacade {

	private final RedisLockRepository redisLockRepository;
	private final StockService stockService;

	public LettuceLockStockFacade(RedisLockRepository redisLockRepository,
		StockService stockService) {
		this.redisLockRepository = redisLockRepository;
		this.stockService = stockService;
	}

	public void decrease(Long key, Long quantity) throws InterruptedException {
		while (!redisLockRepository.lock(key)) {
			Thread.sleep(100);
		}

		try {
			stockService.decrease(key, quantity);
		} finally {
			redisLockRepository.unlock(key);
		}
	}
}
