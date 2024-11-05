/**
 * Author: Eda Akyıl
 * User:edaakyil
 * Date:5.11.2024
 * Time:18:06
 */

package com.edaakyil.util.numeric;

import com.edaakyil.util.numeric.data.LongIntDataInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
@RunWith(Parameterized.class)
public class NumberUtilSumFactorsTest {
    public LongIntDataInfo dataInfo;

    public NumberUtilSumFactorsTest(LongIntDataInfo dataInfo)
    {
        this.dataInfo = dataInfo;
    }

    @Parameterized.Parameters
    public static Collection<LongIntDataInfo> createData()
    {
        return List.of(
                new LongIntDataInfo(-2, 1),
                new LongIntDataInfo(-1, 1),
                new LongIntDataInfo(1, 1),
                new LongIntDataInfo(2, 1),
                new LongIntDataInfo(3, 1),
                new LongIntDataInfo(10, 8),
                new LongIntDataInfo(60, 108),
                new LongIntDataInfo(1000, 1340),
                new LongIntDataInfo(1000000, 1480437)
        );
    }

    @Test
    public void test()
    {
        assertEquals(dataInfo.expected, NumberUtil.sumFactors(dataInfo.input));
    }
}
