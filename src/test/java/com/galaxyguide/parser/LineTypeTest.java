package com.galaxyguide.parser;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.sound.sampled.Line;

import com.galaxyguide.io.LineType;

import junit.framework.TestCase;

public class LineTypeTest extends TestCase {

	public void testValidLineTypes() {
		Pattern pattern = LineType.ASSIGNMENT_LINE.getPattern();
		assertEquals(true, pattern.matcher("glob is I").matches());
		pattern = LineType.METAL_CREDIT_LINE.getPattern();
		assertEquals(true, pattern.matcher("glob prok Silver is 34 Credits")
				.matches());
		pattern = LineType.QSTN_ASK_INTERGALACTIC_NUMBER_VALUE
				.getPattern();
		assertEquals(true, pattern.matcher("how much is pish tegj glob glob ?")
				.matches());
		pattern = LineType.QSTN_ASK_METAL_CREDITS.getPattern();
		assertEquals(true,
				pattern.matcher("how many Credits is glob prok Silver ?")
						.matches());
	}
	
	public void testInvalidLineTypes() {
		Pattern pattern = LineType.ASSIGNMENT_LINE.getPattern();
		assertEquals(false, pattern.matcher("glob glob is I").matches());
		assertEquals(false, pattern.matcher("glob is IV").matches());
		
		pattern = LineType.METAL_CREDIT_LINE.getPattern();
		assertEquals(false, pattern.matcher("glob prok is 34 Credits")
				.matches());
		assertEquals(false, pattern.matcher("glob prok Silver is 34.0 Credits")
				.matches());
		
		pattern = LineType.QSTN_ASK_INTERGALACTIC_NUMBER_VALUE
				.getPattern();
		assertEquals(false, pattern.matcher("how much is pish tegj glob glob XX?")
				.matches());
		pattern = LineType.QSTN_ASK_METAL_CREDITS.getPattern();
		assertEquals(false,
				pattern.matcher("how many Credits is glob prok ?")
						.matches());
		assertEquals(false,
				pattern.matcher("how many Credits is Silver ?")
						.matches());
		
	}
	
	public void testTokens() {
	
		ArrayList<String> tokens = LineType.ASSIGNMENT_LINE.getTokens("glob is I");
		assertEquals("glob", tokens.get(0));
		assertEquals("I", tokens.get(1));
		
		tokens = LineType.METAL_CREDIT_LINE.getTokens("glob prok Silver is 34 Credits");
		assertEquals("glob prok", tokens.get(0));
		assertEquals("Silver", tokens.get(1));
		assertEquals("34", tokens.get(2));
		
		tokens = LineType.QSTN_ASK_INTERGALACTIC_NUMBER_VALUE.getTokens("how much is pish tegj glob glob ?");
		assertEquals("pish tegj glob glob", tokens.get(0));
		
		tokens = LineType.QSTN_ASK_METAL_CREDITS.getTokens("how many Credits is glob prok Silver ?");
		assertEquals("glob prok", tokens.get(0));
		assertEquals("Silver", tokens.get(1));

	}
}
