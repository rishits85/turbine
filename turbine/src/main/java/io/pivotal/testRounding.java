package io.pivotal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testRounding {
    TurbineApplication turbineApplication;

    @Before
    public void init(){
        this.turbineApplication = new TurbineApplication();
    }

    @Test
    public void testWithVals(){
        int[] test = new int[]{29,35,0,-1,38,39,40,98,84,95};
        TurbineApplication turbineApplication = new TurbineApplication();
        for(int i: turbineApplication.getRoundingAbove40(test)){
            System.out.println(i);
        }

    }

    @Test
    public void testWithEmptyObject(){
        Assert.assertTrue(turbineApplication.getRoundingAbove40(new int[0]).length==0);
    }

    @Test
    public void testWithNull(){
        Assert.assertTrue(turbineApplication.getRoundingAbove40(null).length==0);
    }
}
