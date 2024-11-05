package com.edaakyil.util.numeric;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class NumberUtilIsPrimeTest {
    @Ignore("Tested before")
    @Test
    public void givenValue_WhenNumber_ThenReturnsTrue()
    {
        int input = 1_000_003;

        Assert.assertTrue(NumberUtil.isPrime(input));
    }

    @Ignore("Tested before")
    @Test
    public void givenValue_WhenNumber_ThenReturnsFalse()
    {
        int input = 1233    ;

        Assert.assertFalse(NumberUtil.isPrime(input));
    }
}
