package com.softserve.edu.homework02;

import org.testng.annotations.Test;

public class homework02test {

    @Test
    void Add1test() {
        System.out.println("test1");
        // From Maven
        System.out.println("***surefire.java.version = " + System.getProperty("surefire.java.version"));
        // From OS
        System.out.println("***System.getenv(\"MY_PASSWORD\") = " + System.getenv("MY_PASSWORD"));
        System.out.println("***System.getenv(\"DEFAULT_PASS\") = " + System.getenv("DEFAULT_PASS"));
        // From Eclipse/Idea
        System.out.println("***System.getenv().MY_IDE = " + System.getenv().get("MY_IDE"));
    }

}
