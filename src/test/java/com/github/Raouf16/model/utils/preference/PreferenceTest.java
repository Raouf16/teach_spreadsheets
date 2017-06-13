package com.github.Raouf16;

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
		if(expected.compareTo(p.getYear())== 0){
			System.out.println ("test set get succed");	
		}else{
			System.out.println ("test set get failed");	
		}
		
		
	}
	@Test
	public void testSubject() {
		Preference p = new Preference ();
		 
		p.setSubject("sujet");
		//expected from the geter is sujet
		String expected ="sujet";
		if(expected.compareTo(p.getSubject())== 0){
			System.out.println ("test set get for subject succed");	
		}else{
			System.out.println ("test set get for subject failed");	
		}
		
		
	}
	@Test
	// in this method we must check if the string is really modified to an int
	public void testnbrTD() {
		Preference p = new Preference ();
		 
		p.setNbrTD("5");
		//expected from the geter is 5 as an int
		int expected =5;
		if(expected == p.getNbrTD()){
			System.out.println ("test set get for nbrTD succed");	
		}else{
			System.out.println ("test set get for nbrTD failed");	
		}
		
		
	}
}
