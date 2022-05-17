package com.bnta.chocolate;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.service.ChocolateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ChocolateApplicationTests {

	@Autowired
	private ChocolateService chocolateService;

	@Test
	void queryTest() {
		List<Chocolate> chocolateList = chocolateService.getByPercentage(60);
		Chocolate match = chocolateList.get(0);
		assertAll("Should return a Chocolate object with the following properties",
			() -> assertEquals(4, match.getId()),
			() -> assertEquals("Name4", match.getName()),
			() -> assertEquals(100, match.getCocoaPercentage())
		);
	}

	
}
