package org.dave.fibonacci.domain.model;

public class FibonacciNumber {

	public static final FibonacciNumber SEED = new FibonacciNumber(0,1);
	
	private long current, next;

	public FibonacciNumber(long current, long next) {
		super();
		this.current = current;
		this.next = next;
	}

	public long getCurrent() {
		return current;
	}

	public FibonacciNumber generateNext() {
		return new FibonacciNumber(next, Math.addExact(current , next));
	}
}
