/**
 * Author: Eda Akyıl
 * User:edaakyil
 * Date:5.11.2024
 * Time:18:13
 */

package com.edaakyil.util.numeric;

import com.edaakyil.util.numeric.data.IntIntDataInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
@RunWith(Parameterized.class)
public class NumberUtilReverseTest {
    public IntIntDataInfo dataInfo;

    public NumberUtilReverseTest(IntIntDataInfo dataInfo)
    {
        this.dataInfo = dataInfo;
    }

    @Parameterized.Parameters
    public static Collection<IntIntDataInfo> createdData()
    {
        return List.of(
                new IntIntDataInfo(12345678, 87654321),
                new IntIntDataInfo(546, 645),
                new IntIntDataInfo(1, 1),
                new IntIntDataInfo(234, 432),
                new IntIntDataInfo(398, 893),
                new IntIntDataInfo(55, 55),
                new IntIntDataInfo(324, 423),
                new IntIntDataInfo(78, 87),
                new IntIntDataInfo(325, 523)
        );
    }

    @Test
    public void test()
    {
        assertEquals(dataInfo.expected, NumberUtil.reverse(dataInfo.input));
    }
}
