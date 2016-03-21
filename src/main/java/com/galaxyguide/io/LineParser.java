package com.galaxyguide.io;

import java.util.ArrayList;

import com.galaxyguide.metals.MetalsRepository;
import com.galaxyguide.metals.MetalsRepository.Metal;
import com.galaxyguide.numbers.ConversionHelper;
import com.galaxyguide.numbers.RomanNumber;
import com.galaxyguide.numbers.RomanNumber.RomanNumerals;
/*
 * This class processes each input line, calculates and returns answer lines for questions
 */
public class LineParser { 
	
	public static String processLine(String line) throws Exception {		
		for (LineType lineType : LineType.values()) {
			if(lineType.getPattern() != null
					&& lineType.getPattern().matcher(line).matches()) {
				return parseLine(lineType, line);
			}
		}
		return LineType.INVALID_LINE.getAnswerFormat();
	}
	
	public static String parseLine(LineType lineType, String line) throws Exception {
		ArrayList<String> tokens = lineType.getTokens(line);
		String interGalacticNumberStr = null;
		String metalName = null;
		RomanNumber number = null;
		
		switch (lineType) {		
		case ASSIGNMENT_LINE:
			String interGalacticNumeral = tokens.get(0);
			RomanNumerals romanNumeral = RomanNumerals.findNumeralFromChar(tokens.get(1).charAt(0));
			ConversionHelper.galacticToRomanNumeralMappings.put(interGalacticNumeral, romanNumeral);					
			break;
		case METAL_CREDIT_LINE:
			interGalacticNumberStr = tokens.get(0);
			RomanNumber totalMetalUnits = ConversionHelper.getRelevantRomanNumber(interGalacticNumberStr);
			
			metalName = tokens.get(1);
			String totalCredits = tokens.get(2);
			
			double unitMetalPrice = Integer.parseInt(totalCredits) / (double)totalMetalUnits.getValue();
			MetalsRepository.addMetal(new Metal(metalName, unitMetalPrice));			
			break;
		case QSTN_ASK_INTERGALACTIC_NUMBER_VALUE:
			interGalacticNumberStr = tokens.get(0);
			number = ConversionHelper.getRelevantRomanNumber(interGalacticNumberStr);
			return String.format(lineType.getAnswerFormat(), interGalacticNumberStr, number.getValue());
		case QSTN_ASK_METAL_CREDITS:
			interGalacticNumberStr = tokens.get(0);
			number = ConversionHelper.getRelevantRomanNumber(interGalacticNumberStr);
			metalName = tokens.get(1);
			Metal metal = MetalsRepository.findMetal(new Metal(metalName));
			return String.format(lineType.getAnswerFormat(), interGalacticNumberStr,
								metal.getMetalName(), 
								metal.getTotalPriceForUnits(number.getValue()));
		default:
			break;
		}		
		return null;
	}
}
