package io.pivotal;

import org.junit.Test;

public class testStringToNumbers {

    @Test
    public void singleNumbersTest(){
        String test1 = "one.plus.two.minus.three";
        TurbineApplication turbineApplication = new TurbineApplication();
        System.out.println(turbineApplication.convertToNumbersAndOperators(test1));
    }


    @Test
    public void doubleNumbersTest(){
        String test1 = "one.one.plus.one.two.minus.one.three";
        TurbineApplication turbineApplication = new TurbineApplication();
        System.out.println(turbineApplication.convertToNumbersAndOperators(test1));
    }
}
