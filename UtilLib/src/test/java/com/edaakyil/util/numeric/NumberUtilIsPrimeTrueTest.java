/**
 * Author: Eda Akyıl
 * User:edaakyil
 * Date:5.11.2024
 * Time:16:18
 */

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
public class NumberUtilIsPrimeTrueTest {
    public long input;

    public NumberUtilIsPrimeTrueTest(long input)
    {
        this.input = input;
    }


    @Parameterized.Parameters
    public static Collection<Long> createData()
    {
        return List.of(710_584_055_392_819_667L, 1_386_437_196_678_024_971L, 19L, 71L, 569_785_970_6174_583_067L);
    }

    @Test
    public void test()
    {
        Assert.assertTrue(NumberUtil.isPrime(input));
    }
}
