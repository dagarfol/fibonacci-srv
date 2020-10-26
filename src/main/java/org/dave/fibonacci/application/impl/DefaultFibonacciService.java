package org.dave.fibonacci.application.impl;

import java.util.stream.Stream;

import org.dave.fibonacci.application.FibonacciService;
import org.springframework.stereotype.Service;

@Service
public class DefaultFibonacciService implements FibonacciService {
	
	private static final FibonacciPair SEED = new FibonacciPair(0,1);

	@Override
	public long getValueFor(int number) {
		if(number < 0) {
			return -1l;
		}else {
			return Stream.iterate(SEED, pair -> new FibonacciPair(pair.getNext(), Math.addExact(pair.getCurrent() , pair.getNext())))
			.limit(number + 1)
			.skip(number)
			.findFirst().get().getCurrent();
		}
	}

	private static class FibonacciPair{
		private long current, next;

		public FibonacciPair(long current, long next) {
			super();
			this.current = current;
			this.next = next;
		}

		public long getCurrent() {
			return current;
		}

		public long getNext() {
			return next;
		}
	}
	
}
