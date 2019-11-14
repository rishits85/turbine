package io.pivotal;

import org.junit.Test;

public class testRounding {

    @Test
    public void testWithVals(){
        int[] test = new int[]{29,35,0,-1,38,39,40,98,84,95};
        TurbineApplication turbineApplication = new TurbineApplication();
        for(int i: turbineApplication.getRoundingAbove40(test)){
            System.out.println(i);
        }

    }
}
