package com.galaxyguide.numbers;

import junit.framework.TestCase;

public class RomanNumberTest extends TestCase {
	public void testValidRomanNumbers() throws Exception {
		assertEquals(1917, new RomanNumber("MCMXVII").getValue());
		assertEquals(99, new RomanNumber("XCIX").getValue());
		assertEquals(0, new RomanNumber("").getValue());
		assertEquals(true, RomanNumber.isValidNumber("MCML"));
		assertEquals(false, RomanNumber.isValidNumber("MCMD"));		
	}
	
	public void testValidPattern() {
		assertEquals(true, RomanNumber.isValidNumber("IX"));
		assertEquals(true, RomanNumber.isValidNumber("MCMIV"));
	}
	
	public void testInvalidPattern() {
		assertEquals(false, RomanNumber.isValidNumber("IXXXX"));
		assertEquals(false, RomanNumber.isValidNumber("MCMDIV"));
	}
	
	public void testGetRomanNumerals() throws Exception {		
		assertEquals("I", RomanNumber.RomanNumerals.findNumeralFromChar('I').toString());
		assertEquals("V", RomanNumber.RomanNumerals.findNumeralFromChar('V').toString());
		assertEquals("X", RomanNumber.RomanNumerals.findNumeralFromChar('X').toString());
		assertEquals("L", RomanNumber.RomanNumerals.findNumeralFromChar('L').toString());
		assertEquals("C", RomanNumber.RomanNumerals.findNumeralFromChar('C').toString());
		assertEquals("D", RomanNumber.RomanNumerals.findNumeralFromChar('D').toString());
		assertEquals("M", RomanNumber.RomanNumerals.findNumeralFromChar('M').toString());
	}	
}
