package org.dave.fibonacci.domain.repos.impl;

import java.util.ArrayList;
import java.util.List;

import org.dave.fibonacci.domain.model.FibonacciNumber;
import org.dave.fibonacci.domain.repos.FibonacciValuesRepository;
import org.springframework.stereotype.Component;

@Component
public class CacheBasedValuesRepository implements FibonacciValuesRepository{
	
	private List<FibonacciNumber> values;
	
	public CacheBasedValuesRepository() {
		values = new ArrayList<FibonacciNumber>();
	}

	@Override
	public FibonacciNumber getByIndex(int index) {
		return values.get(index);
	}

	@Override
	public int getHighestIndex() {
		return values.size()-1;
	}

	@Override
	public void addValue(FibonacciNumber value) {
		values.add(value);
	}

}
