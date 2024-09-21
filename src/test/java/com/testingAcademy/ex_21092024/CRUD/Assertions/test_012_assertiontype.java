package com.testingAcademy.ex_21092024.CRUD.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class test_012_assertiontype {
    @Test
    public void hardAssertExample() {
        Assert.assertTrue(false); // This will throw an AssertionError and stop execution.
        System.out.println("This line will not be executed.");
    }
 // one type of assertion(hard and soft)
    // hard assertion if first line failed it will stop the execution
    //soft assertion - if the first failed also it will execute and it will not stop the execution

    @Test
    public void softAssertExample() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false); // This will not stop execution.
        System.out.println("This line will be executed.");
        softAssert.assertAll(); // This will report all collected errors.
    }
}
