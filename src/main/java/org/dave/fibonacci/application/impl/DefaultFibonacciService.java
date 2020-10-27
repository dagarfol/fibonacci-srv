package org.dave.fibonacci.application.impl;

import java.util.stream.Stream;

import org.dave.fibonacci.application.FibonacciService;
import org.dave.fibonacci.domain.model.FibonacciNumber;
import org.dave.fibonacci.domain.repos.FibonacciValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultFibonacciService implements FibonacciService {
	
	@Autowired
	FibonacciValuesRepository valuesRepo;

	@Override
	public long getValueFor(int number) {
		if(number < 0) {
			return -1l;
		}else if(number <= valuesRepo.getHighestIndex()) {
			return valuesRepo.getByIndex(number).getCurrent();
		}else {
			generateValuesUntil(number);
			return valuesRepo.getByIndex(number).getCurrent();
		}
	}
	
	private void generateValuesUntil(int number) {
		int valuesToGenerate = number - valuesRepo.getHighestIndex();
		FibonacciNumber seed = valuesRepo.getHighestIndex() < 0? 
				FibonacciNumber.SEED :
				valuesRepo.getByIndex(valuesRepo.getHighestIndex()).generateNext();
		Stream.iterate(seed, pair -> pair.generateNext())
		.limit(valuesToGenerate)
		.forEachOrdered(valuesRepo::addValue);
	}

}
