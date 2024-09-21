package com.testingAcademy.ex_21092024.CRUD;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test_06 {
    @Test(groups = {"sanity","qa","preprod"})
    public void sanityRun()
    {
        System.out.println("sanity");          //using groups we can find run particular test case
        System.out.println("qa");
        Assert.assertTrue(true);
    }
    @Test(groups = {"reg","qa","preprod"})
    public void RegRun()
    {
        System.out.println("reg");
        System.out.println("qa");
        Assert.assertTrue(true);
    }
    @Test(groups = {"dev","stage"})
    public void SmokeRun3(){
        System.out.println("Smoke");
        Assert.assertTrue(true);
    }
}
