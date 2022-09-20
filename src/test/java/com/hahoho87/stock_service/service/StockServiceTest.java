package com.hahoho87.stock_service.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hahoho87.stock_service.domain.Stock;
import com.hahoho87.stock_service.repository.StockRepository;

@SpringBootTest
class StockServiceTest {

	@Autowired
	private StockService stockService;

	@Autowired
	private StockRepository stockRepository;

	@BeforeEach
	void init() {
		Stock stock = new Stock(1L, 100L);
		stockRepository.save(stock);
	}

	@AfterEach
	void clean() {
		stockRepository.deleteAll();
	}

	@Test
	@DisplayName("재고를 감소시킨다.")
	void decreaseTest() {
		// given
		Long id = 1L;
		Long quantity = 10L;

		// when
		stockService.decrease(id, quantity);

		// then
		Stock stock = stockRepository.findById(id).get();
		assertThat(stock.getQuantity()).isEqualTo(90L);
	}

}