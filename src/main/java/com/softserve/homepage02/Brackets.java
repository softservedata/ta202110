package com.softserve.homepage02;

import java.util.Stack;

public class Brackets {

	public boolean verifyBrackets(String text) {
		Stack<String> stack = new Stack<>();
		try {
			for (int i = 0; i < text.length(); i++) {

				if (text.charAt(i) == ('(')) {
					stack.push("(");
				} else if (text.charAt(i) == (')')) {
					stack.pop();
				}
			}

			if (stack.isEmpty()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
