package io.pivotal;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class testSingleRepeatName {

    @Test
    public void test1(){
        TurbineApplication turbineApplication = new TurbineApplication();
        Assert.assertEquals("n3",turbineApplication.findSingleRepeatName(Arrays.asList("n1","n2","n1","n2","n3")));
    }
}
