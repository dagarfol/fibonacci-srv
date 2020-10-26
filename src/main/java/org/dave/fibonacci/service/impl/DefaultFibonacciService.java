package org.dave.fibonacci.service.impl;

import org.dave.fibonacci.service.FibonacciService;
import org.springframework.stereotype.Service;

@Service
public class DefaultFibonacciService implements FibonacciService {

	@Override
	public long getValueFor(long number) {
		if(number < 0) {
			return -1l;
		}else if(number == 0l || number == 1l) {
			return number;
		}else {
			long grandParent = 0;
			long parent = 1;
			long result = 1;
			for(long n = 2; n <= number; n++) {
				result = Math.addExact(parent, grandParent);
				grandParent = parent;
				parent = result;
			}
			return result;
//			return getFibonacciOf(number-1) + getFibonacciOf(number-2);
		}
	}
}
