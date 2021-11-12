package com.softserve.edu.homework02;

import org.junit.Assert;
import org.junit.Test;

public class TestVerifyBrackets {

    VerifyBrackets brackets = new VerifyBrackets();

    @Test
    public void positiveVerifyBrackets(){
        Assert.assertTrue(brackets.verifyBrackets("(())"));
    }
    @Test
    public void negativeVerifyBrackets(){
        Assert.assertFalse(brackets.verifyBrackets("())"));
    }
}
