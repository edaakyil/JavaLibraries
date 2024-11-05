/**
 * Author: Eda Akyıl
 * User:edaakyil
 * Date:5.11.2024
 * Time:17:54
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
public class NumberUtilGetPrimeTest {
    public IntLongDataInfo dataInfo;

    public NumberUtilGetPrimeTest(IntLongDataInfo dataInfo)
    {
        this.dataInfo = dataInfo;
    }

    @Parameterized.Parameters
    public static Collection<IntLongDataInfo> createData()
    {
        return List.of(
                new IntLongDataInfo(1, 2),
                new IntLongDataInfo(2, 3),
                new IntLongDataInfo(3, 5),
                new IntLongDataInfo(4, 7),
                new IntLongDataInfo(962, 7577),
                new IntLongDataInfo(17569, 194933)
        );
    }

    @Test
    public void test()
    {
        assertEquals(dataInfo.expected, NumberUtil.getPrime(dataInfo.input));
    }
}
