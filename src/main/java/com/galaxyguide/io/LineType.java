package com.galaxyguide.io;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This class defines grammars for valid/invalid input lines, also it defines the answer formats for 
 * lines which are question lines.
 */
public enum LineType {
	ASSIGNMENT_LINE("([a-z]+){1}+ is ([I|V|X|L|C|D|M]){1}+", null),
	METAL_CREDIT_LINE("([a-z ]+){1}+([A-Za-z]+){1}+ is ([0-9]+){1} Credits", null),
	QSTN_ASK_INTERGALACTIC_NUMBER_VALUE("how much is ([a-z ]+){1}+\\?", "%s is %d\r\n"),
	QSTN_ASK_METAL_CREDITS("how many Credits is ([a-z ]+){1}+([A-Za-z]+){1}+ \\?", "%s %s is %d Credits\r\n"),
	INVALID_LINE(null, "I have no idea what you are talking about\r\n");

	private final Pattern pattern;
	private final String answerFormat;

	LineType(String patternString, String answerFormat) {
		if (patternString != null) {
			pattern = Pattern.compile(patternString);
		} else {
			this.pattern = null;
		}
		this.answerFormat = answerFormat;
	}
	
	public Pattern getPattern() {
		return pattern;
	}
	
	public String getAnswerFormat() {
		return answerFormat;
	}

	public ArrayList<String> getTokens(String input) {
		ArrayList<String> tokens = new ArrayList<String>();
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			// first group is always entire string, groupCount values are not
			// zero based
			for (int i = 1; i <= matcher.groupCount(); i++) {
				tokens.add(matcher.group(i).trim());
			}
		}
		return tokens;
	}
}
