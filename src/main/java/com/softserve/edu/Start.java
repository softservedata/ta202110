package com.softserve.edu;


import org.testng.annotations.Test;

public class Start {
    @Test
            public void  start(){
        System.out.println("***surefire.java.version = " + System.getProperty("surefire.java.version"));
        System.out.println("***System.getenv(\"MY_PASSWORD\") = " + System.getenv("MY_PASSWORD"));
        System.out.println("***System.getenv().MY_IDE = " + System.getenv().get("MY_IDE"));
    }

}
