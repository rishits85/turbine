package io.pivotal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class testSingleRepeatName {

    TurbineApplication turbineApplication;

    @Before
    public void init(){
        this.turbineApplication = new TurbineApplication();
    }

    @Test
    public void test1(){
        TurbineApplication turbineApplication = new TurbineApplication();
        Assert.assertEquals("n3",turbineApplication.findSingleRepeatName(Arrays.asList("n1","n2","n1","n2","n3")));
    }

    @Test
    public void testWithNoSingleRepeates(){
        Assert.assertNull(turbineApplication.findSingleRepeatName(Arrays.asList("n1","n2","n1","n2","n2","n3","n3")));
    }

    @Test
    public void testWithMultipleSingleRepeats(){
        Assert.assertEquals("n4",turbineApplication.findSingleRepeatName(Arrays.asList("n1","n2","n1","n3","n4")));
    }
}
