package org.dave.fibonacci.domain.repos;

import org.dave.fibonacci.domain.model.FibonacciNumber;

public interface FibonacciValuesRepository {

	public FibonacciNumber getByIndex(int index);
	
	public int getHighestIndex();
	
	public void addValue(FibonacciNumber value);
}
