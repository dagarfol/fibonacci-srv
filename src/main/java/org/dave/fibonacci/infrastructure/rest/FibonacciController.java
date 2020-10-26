package org.dave.fibonacci.infrastructure.rest;

import org.dave.fibonacci.application.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/fibonacci")
public class FibonacciController {

	@Autowired
	private FibonacciService fibonacciService;
	
	@GetMapping
	public long getValueFor(@RequestParam("number") int number) {
		return fibonacciService.getValueFor(number);
	}
}
