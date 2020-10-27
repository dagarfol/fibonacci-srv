package org.dave.fibonacci.domain.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.dave.fibonacci.domain.repos.FibonacciValuesRepository;
import org.dave.fibonacci.domain.service.FibonacciService;
import org.dave.fibonacci.domain.service.impl.DefaultFibonacciService;
import org.dave.fibonacci.infrastructure.data.CacheBasedValuesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class DefaultFibonacciServiceTest {

	@TestConfiguration
	static class DefaultFibonacciServiceTestContextConfiguration {
		
		@Bean
		public FibonacciService fibonacciService() {
			return new DefaultFibonacciService();
		}
		
		@Bean
		public FibonacciValuesRepository fibonacciValuesRepository() {
			return new CacheBasedValuesRepository();
		}
	}

    @Autowired
	FibonacciService fibonacciService;
	
	@Test
	public void given0shouldReturn0() {
		assertThat(0l, is(fibonacciService.getValueFor(0)));
	}

	@Test
	public void given1shouldReturn1() {
		assertThat(1l, is(fibonacciService.getValueFor(1)));
	}

	@Test
	public void given2shouldReturn1() {
		assertThat(1l, is(fibonacciService.getValueFor(2)));
	}
	
	@Test
	public void given3shouldReturn2() {
		assertThat(2l, is(fibonacciService.getValueFor(3)));
	}
	
	@Test
	public void given4shouldReturn3() {
		assertThat(3l, is(fibonacciService.getValueFor(4)));
	}
	
	@Test
	public void given5shouldReturn5() {
		assertThat(5l, is(fibonacciService.getValueFor(5)));
	}
	
	@Test
	public void given6shouldReturn8() {
		assertThat(8l, is(fibonacciService.getValueFor(6)));
	}
	
	@Test
	public void givenAHighNumberShouldFailWithException() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			fibonacciService.getValueFor(1000);
		});
	}
	
	@Test
	public void givenNegativeNumberShouldReturnMinusOne() {
		assertThat(-1l, is(fibonacciService.getValueFor(-3)));
	}
	
}
