package com.edaakyil.util.numeric;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("Tested before and passed")
public class NumberUtilFibonacciTest {
    @Test
    public void givenValue_WhenIndex_ThenReturnsNumber()
    {
        int expected = 3;
        int input = 5;

        Assert.assertEquals(expected, NumberUtil.fibonacciNumber(input));
    }
}
