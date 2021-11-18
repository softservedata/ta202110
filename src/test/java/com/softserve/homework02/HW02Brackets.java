package com.softserve.homework02;

public class HW02Brackets {

	public boolean verifyBrackets(String text) {
		
		int numberBracket = 0;
		
		for (int i=0; i < text.length(); i++) {
			if (text.charAt(i) == '(') {numberBracket++;}
			if (text.charAt(i) == ')') {numberBracket--;}
			if (numberBracket < 0) {return false;}
		}
		
		if (numberBracket == 0) {return true;}
			else {return false;}
	}
}
