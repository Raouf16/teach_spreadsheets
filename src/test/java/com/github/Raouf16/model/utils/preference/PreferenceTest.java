package com.github.Raouf16.model.utils.preference;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.Raouf16.model.utils.preference.Preference;

public class PreferenceTest {

	@Test
	public void testYear() {
		Preference p = new Preference ();
		 
		p.setYear("2017");
		//expected from the geter is 2017
		String expected ="2017";
		assertEquals(expected,p.getYear());
		
		
		
	}
	@Test
	public void testSubject() {
		Preference p = new Preference ();
		 
		p.setSubject("sujet");
		//expected from the geter is sujet
		String expected ="sujet";
		assertEquals(expected,p.getSubject());
		
		
		
	}
	@Test
	// in this method we must check if the string is really modified to an int
	public void testnbrTD() {
		Preference p = new Preference ();
		 
		p.setNbrTD("5");
		//expected from the geter is 5 as an int
		int expected =5;
		assertEquals(expected,p.getNbrTD());
		
	}
}
