package com.edaakyil.util.numeric;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class NumberUtilFibonacciTest {
    DataInfo dataInfo;

    public NumberUtilFibonacciTest(DataInfo info)
    {
        dataInfo = info;
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> cerateData()
    {
        return List.of(new DataInfo(1, 0), new DataInfo(2, 1), new DataInfo(3, 1), new DataInfo(4, 2), new DataInfo(5, 3));
    }

    static class DataInfo {
        int input;
        int expected;

            DataInfo(int a, int b)
            {
                input = a;
                expected = b;
            }
    }
    @Test
    public void givenValue_WhenIndex_ThenReturnsNumber()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.fibonacciNumber(dataInfo.input));
    }
}
