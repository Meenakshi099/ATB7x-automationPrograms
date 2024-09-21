package com.testingAcademy.ex_21092024.CRUD;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test_03 {
    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }
    @BeforeTest
    public void getBookingID(){        //no order of sequence followed here!
        System.out.println("2");       //in @beforeTest
    }
    @Description("Verify that  true ==  true")
    @Test
    public void test_PUT(){
        // token and BookingID
        System.out.println("3");
    }
}
