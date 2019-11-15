package io.pivotal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

public class test {

/*test case does not include the data for invalid */
    @Test
    public void testMain(){
        TurbineApplication turbineApplication  = new TurbineApplication();
        int[][] testObj = new int[3][3];

        testObj[0][0] = 1;
        testObj[0][1] = 3;
        testObj[0][2] = 5;
        testObj[1][0] = 2;
        testObj[1][1] = 9;
        testObj[1][2] = 8;
        testObj[2][0] = 4;
        testObj[2][1] = 6;
        testObj[2][2] = 7;

        Assert.assertEquals(4,turbineApplication.calculateTime(testObj, "3,7,8"));
    }

    @Test
    public void testMainInvalid(){
        TurbineApplication turbineApplication  = new TurbineApplication();
        int[][] testObj = new int[3][3];

        testObj[0][0] = 1;
        testObj[0][1] = 3;
        testObj[0][2] = 5;
        testObj[1][0] = 2;
        testObj[1][1] = 9;
        testObj[1][2] = 8;
        testObj[2][0] = 4;
        testObj[2][1] = 6;
        testObj[2][2] = 7;

        Assert.assertEquals(-1,turbineApplication.calculateTime(testObj, "ab"));
    }
}
