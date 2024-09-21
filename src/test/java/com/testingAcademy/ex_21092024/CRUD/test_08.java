package com.testingAcademy.ex_21092024.CRUD;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test_08 {
    @Parameters("Browser")
            @Test
        void demo1(String value)
    {
        System.out.println("Browser is"  +value);
    }

}
