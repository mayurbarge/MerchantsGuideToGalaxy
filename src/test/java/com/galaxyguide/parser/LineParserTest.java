package com.galaxyguide.parser;

import com.galaxyguide.io.LineParser;
import com.galaxyguide.io.LineType;
import com.galaxyguide.metals.MetalsRepository;
import com.galaxyguide.metals.MetalsRepository.Metal;
import com.galaxyguide.numbers.ConversionHelper;
import com.galaxyguide.numbers.RomanNumber;

import junit.framework.TestCase;

public class LineParserTest extends TestCase {
	
	public void testParseLine() throws Exception {
		LineParser.parseLine(LineType.ASSIGNMENT_LINE, "glob is I");
		assertEquals(RomanNumber.RomanNumerals.I, ConversionHelper.galacticToRomanNumeralMappings.get("glob"));
		
		LineParser.parseLine(LineType.ASSIGNMENT_LINE, "prok is V");
		LineParser.parseLine(LineType.ASSIGNMENT_LINE, "pish is X");
		LineParser.parseLine(LineType.ASSIGNMENT_LINE, "tegj is L");
		
		LineParser.parseLine(LineType.METAL_CREDIT_LINE, "glob glob Silver is 34 Credits");
		assertEquals("Silver", MetalsRepository.findMetal(new Metal("Silver")).getMetalName() );
		assertEquals(17.0, MetalsRepository.findMetal(new Metal("Silver")).getUnitPrice() );
		
		String result = LineParser.parseLine(LineType.QSTN_ASK_INTERGALACTIC_NUMBER_VALUE, "how much is pish tegj glob glob ?");
		assertEquals("pish tegj glob glob is 42\r\n", result);
		
		result = LineParser.parseLine(LineType.QSTN_ASK_METAL_CREDITS, "how many Credits is glob prok Silver ?");
		assertEquals("glob prok Silver is 68 Credits\r\n", result);
		
		
		
	}
}
