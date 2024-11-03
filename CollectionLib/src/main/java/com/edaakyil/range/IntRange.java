package com.edaakyil.range;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntRange implements Iterable<Integer> {
    private final int m_a;
    private final int m_b;

    private IntRange(int a, int b)
    {
        m_a = a;
        m_b = b;
    }

    public static IntRange of(int a, int b)
    {
        if (a > b)
            throw new IllegalArgumentException(String.format("a can not be greater than b: a = %d, b = %d", a, b));

        return new IntRange(a, b);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int index; // initial value of index is 0 (zero)

            @Override
            public boolean hasNext()
            {
                return m_a + index <= m_b;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such element!...");
            }
        };
    }
}
