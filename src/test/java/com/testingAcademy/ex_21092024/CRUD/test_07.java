package com.testingAcademy.ex_21092024.CRUD;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test_07 {
    @Test
    public void serverStartedOk() {
        System.out.println("I will run first");
        Assert.assertTrue(false);    //dependson this also kind of order of sequence
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method1() {
        System.out.println("method1");
    }
}
