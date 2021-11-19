package com.softserve.homework02;

import java.util.Stack;

public class Brackets {

	public boolean verifyBrackets(String text) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '(') {
				stack.push(text.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				Character ch = Character.MIN_VALUE;
				if (text.charAt(i) == ')') {
					ch = stack.pop();
				} else {
					if (stack.isEmpty()) {
						return false;
					}

				}

			}
		}

		return stack.isEmpty();

	}

}
