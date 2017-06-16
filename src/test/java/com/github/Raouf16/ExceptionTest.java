package com.github.Raouf16;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ExceptionTest {
	@Test(expected = IndexOutOfBoundsException.class)
	public void should_throw_exception() throws Exception {
		ArrayList<Integer> List = new ArrayList<>();
		List.add(1);
		List.add(2);
		List.get(2);
		
	}
	
}