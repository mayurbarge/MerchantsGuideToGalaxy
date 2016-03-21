package com.galaxyguide.numbers;

import java.util.HashMap;
import java.util.StringTokenizer;

import com.galaxyguide.numbers.RomanNumber.RomanNumerals;

/*
 * This class is used to convert InterGalacticNumber to its equivalent RomanNumber
 */
public class ConversionHelper {
	
	public static HashMap<String, RomanNumber.RomanNumerals> galacticToRomanNumeralMappings = new HashMap<String, RomanNumber.RomanNumerals>();
		
	public static RomanNumber getRelevantRomanNumber(String interGalacticNumberString) throws Exception {
		StringTokenizer tokenizer = new StringTokenizer(interGalacticNumberString, " ");
		StringBuffer buffer = new StringBuffer();
		
		while(tokenizer.hasMoreTokens()) {
			String interGalacticNumeral = tokenizer.nextToken();
			
			if(!galacticToRomanNumeralMappings.containsKey(interGalacticNumeral)) {
				throw new Exception("Conversion failed: Invalid intergalactic number - " + interGalacticNumberString);
			}
			
			RomanNumerals numeral = galacticToRomanNumeralMappings.get(interGalacticNumeral);
			buffer.append(numeral.name());			
		}
		
		return new RomanNumber(buffer.toString());
	}	
}
