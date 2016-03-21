package com.galaxyguide.numbers;

import java.util.regex.Pattern;

public class RomanNumber {
	public enum RomanNumerals {
		I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

		private int symbolValue;

		RomanNumerals(int symbolValue) {
			this.symbolValue = symbolValue;
		}

		public int getSymbolValue() {
			return symbolValue;
		}

		public static RomanNumerals findNumeralFromChar(char romanNumber) throws Exception {
			switch (romanNumber) {
			case 'I':
				return RomanNumerals.I;
			case 'V':
				return RomanNumerals.V;
			case 'X':
				return RomanNumerals.X;
			case 'L':
				return RomanNumerals.L;
			case 'C':
				return RomanNumerals.C;
			case 'D':
				return RomanNumerals.D;
			case 'M':
				return RomanNumerals.M;
			default:
				break;
			}
			throw new Exception("Invalid roman numeral - " + romanNumber);
		}
	}

	private int value;
	private String number;

	public RomanNumber(String romanNumberString) throws Exception {
		number = romanNumberString;
		if(!isValidNumber(romanNumberString)) {
			throw new Exception("Invalid roman number - " + romanNumberString);
		}
		value = calculateValue();
	}

	/*
	 * Calculates and returns the value for this RomanNumber
	 */
	private int calculateValue() throws Exception {
		int value = 0;
		if (number.length() == 1) {
			return RomanNumerals.findNumeralFromChar(number.charAt(0)).symbolValue;
		}
		for (int i = number.length() - 1; i >= 0; --i) {
			if (i == number.length() - 1) {
				value += RomanNumerals.findNumeralFromChar(number.charAt(i)).symbolValue;
				continue;
			}
			if (RomanNumerals.findNumeralFromChar(number.charAt(i)).symbolValue < RomanNumerals
					.findNumeralFromChar(number.charAt(i + 1)).symbolValue) {
				value -= RomanNumerals.findNumeralFromChar(number.charAt(i)).symbolValue;
			} else {
				value += RomanNumerals.findNumeralFromChar(number.charAt(i)).symbolValue;
			}
		}
		return value;
	}
	
	// pattern to check valid RomanNumber String
	private static final Pattern validPattern = Pattern
			.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

	public static boolean isValidNumber(String romanNumber) {
		return validPattern.matcher(romanNumber).matches();
	}

	public int getValue() {
		return value;
	}
}
