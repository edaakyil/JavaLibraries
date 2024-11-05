/**
 * Author: Eda Akyıl
 * User:edaakyil
 * Date:5.11.2024
 * Time:16:21
 */

package com.edaakyil.util.numeric;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class NumberUtilIsPrimeFalseTest {
    public long input;

    public NumberUtilIsPrimeFalseTest(long input)
    {
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Long> createData()
    {
        return List.of(-1L, 0L, 1L, 12L, 1_000_002L);
    }

    @Test
    public void test()
    {
        Assert.assertFalse(NumberUtil.isPrime(input));
    }
}
