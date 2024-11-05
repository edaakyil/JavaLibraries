/**
 * Author: Eda Akyıl
 * User:edaakyil
 * Date:5.11.2024
 * Time:17:35
 */

package com.edaakyil.util.numeric;

import com.edaakyil.util.numeric.data.IntLongDataInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
@RunWith(Parameterized.class)
public class NumberUtilFactorialTest {
    public IntLongDataInfo dataInfo;

    public NumberUtilFactorialTest(IntLongDataInfo info)
    {
        dataInfo = info;
    }

    @Parameterized.Parameters
    public static Collection<IntLongDataInfo> createData()
    {
        return List.of(new IntLongDataInfo(3, 6L), new IntLongDataInfo(5, 120L), new IntLongDataInfo(13, 6227020800L), new IntLongDataInfo(4, 24));
    }

    @Test
    public void test()
    {
        assertEquals(dataInfo.expected, NumberUtil.factorial(dataInfo.input));
    }
}
