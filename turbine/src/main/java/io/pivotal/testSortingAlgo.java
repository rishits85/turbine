package io.pivotal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testSortingAlgo {

    private TurbineApplication turbineApplication;
    @Before
    public void init(){
        this.turbineApplication = new TurbineApplication();
    }

    @Test
    public void test(){
        int[] arr = new int[]{54,5,1,2,5,6,5,4,4,-23,-2,0};
        TurbineApplication turbineApplication  = new TurbineApplication();
        for(int i: turbineApplication.sort(arr)){
            System.out.println(i);
        };
    }

    @Test
    public void testWithEmptyList(){
        int[] arr = new int[0];
        Assert.assertTrue(turbineApplication.sort(arr).length == 0);
    }

    @Test
    public void testWithNull(){
        Assert.assertTrue(turbineApplication.sort(null).length == 0);
    }

}
