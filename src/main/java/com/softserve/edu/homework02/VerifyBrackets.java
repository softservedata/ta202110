package com.softserve.edu.homework02;

public class VerifyBrackets {

    public boolean verifyBrackets(String text) {
        int rightBrackets = 0;
        int leftBrackets = 0;

        for (char ch: text.toCharArray()){
            if (ch == '(') leftBrackets ++;
            if (ch == ')') rightBrackets ++;
        }
        return rightBrackets == leftBrackets;
    }
}
