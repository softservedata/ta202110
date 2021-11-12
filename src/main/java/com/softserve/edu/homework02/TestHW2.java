package com.softserve.edu.homework02;

import org.junit.Assert;
import org.junit.Test;

public class TestHW2 {
    HW2 brackets = new HW2();
    @Test
    public void positiveVerifyBrackets(){
        Assert.assertTrue(brackets.verifyBrackets("()"));
    }
    @Test
    public void negativeVerifyBrackets(){
        Assert.assertFalse(brackets.verifyBrackets("())"));
    }
}
