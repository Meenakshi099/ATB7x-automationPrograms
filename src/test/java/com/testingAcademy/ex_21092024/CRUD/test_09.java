package com.testingAcademy.ex_21092024.CRUD;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test_09 {
    @Test
    public void test01(){
        Assert.assertTrue(true);      //enabled = false  means skipping the particular test case
    }
    @Test(enabled = false)
    public void test02(){
        Assert.assertTrue(false);
    }
    @Test
    public void test03(){
        Assert.assertTrue(true);
    }
}
