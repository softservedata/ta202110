package com.softserve.homework02;

import org.testng.annotations.Test;

import java.util.Stack;

public class Test2 {

    @Test
    public static void checkBracketBalance() {

  //      String str = "()";
//        String str = "(())";
//        String str = "()()";
        String str = "(()";
//        String str = "())";
//        String str = ")";

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                st.push(str.charAt(i));
            } else if ( !st.empty() && ((str.charAt(i) == ')' && st.peek() == '(') )) {
                st.pop();
            } else {
                st.push(str.charAt(i));
            }
        }

        if(st.empty()) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced");
        }
    }
}
