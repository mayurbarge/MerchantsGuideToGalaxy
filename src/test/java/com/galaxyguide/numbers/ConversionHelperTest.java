package com.galaxyguide.numbers;

import com.galaxyguide.numbers.ConversionHelper;
import com.galaxyguide.numbers.RomanNumber;

import junit.framework.TestCase;

public class ConversionHelperTest extends TestCase {

	public void testValidInterGalacticNumber() throws Exception {
	
			ConversionHelper.galacticToRomanNumeralMappings.put("glob", RomanNumber.RomanNumerals.I);
			ConversionHelper.galacticToRomanNumeralMappings.put("prok", RomanNumber.RomanNumerals.V);
			ConversionHelper.galacticToRomanNumeralMappings.put("pish", RomanNumber.RomanNumerals.X);
			ConversionHelper.galacticToRomanNumeralMappings.put("tegj", RomanNumber.RomanNumerals.L);
			
			RomanNumber number = ConversionHelper.getRelevantRomanNumber("pish tegj glob glob");
			assertEquals(42, number.getValue());
			number = ConversionHelper.getRelevantRomanNumber("glob prok");
			assertEquals(4, number.getValue());
	}
}
