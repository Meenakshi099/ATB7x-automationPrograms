package com.testingAcademy.ex_21092024.CRUD;

import org.testng.annotations.Test;

public class test_05 {
    @Test(priority = 1)
    public void t1(){
        System.out.println("1");          // to follow order there are many ways
    }                                     // one is setting priority

    @Test(priority = 0)
    public void t2(){
        System.out.println("3");
    }

    @Test(priority = 3)
    public void t3(){
        System.out.println("2");
    }
}
