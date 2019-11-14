package io.pivotal;

import org.junit.Test;

public class testSortingAlgo {

    @Test
    public void test(){
        int[] arr = new int[]{54,5,1,2,5,6,5,4,4,-23,-2,0};
        TurbineApplication turbineApplication  = new TurbineApplication();
        for(int i: turbineApplication.sort(arr)){
            System.out.println(i);
        };
    }
}
