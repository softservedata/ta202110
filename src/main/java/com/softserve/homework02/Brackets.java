package com.softserve.homework02;

public class Brackets {

    public boolean verifyBrackets(String text) {

        int bracketsCounter = 0;

        for (int i = 0; i < text.length(); i++) {
            if(bracketsCounter < 0){
                return false;
            } else{
                if (text.charAt(i) == ('(')) {
                    bracketsCounter++;
                } else{
                    if (text.charAt(i) == (')')) {
                        bracketsCounter--;
                    }
                }
                }
        }

        if(bracketsCounter == 0){
            return true;
        } else {
            return false;
        }
    }
}
