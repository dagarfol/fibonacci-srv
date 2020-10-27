package org.dave.fibonacci.application.impl;

import org.dave.fibonacci.application.FibonacciUseCase;
import org.dave.fibonacci.domain.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultFibonacciUseCase implements FibonacciUseCase {
	
	@Autowired
	private FibonacciService fibonacciService;

	@Override
	public long getValueFor(int number) {
		return fibonacciService.getValueFor(number);
	}
	
}
