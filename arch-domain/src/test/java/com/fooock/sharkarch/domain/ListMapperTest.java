package com.fooock.sharkarch.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 *
 */
public class ListMapperTest {

    private IntegerListMapper mIntegerListMapper;

    @Before
    public void setUp() {
        mIntegerListMapper = new IntegerListMapper();
    }

    @Test
    public void testMapper() {
        assertEquals("1", mIntegerListMapper.map(1));
        assertArrayEquals(new String[]{"1", "2", "3"},
                mIntegerListMapper.map(Arrays.asList(1, 2, 3)).toArray());
    }

    @After
    public void tearDown() {
        mIntegerListMapper = null;
    }

    /**
     *
     */
    static class IntegerListMapper implements ListMapper<Integer, String> {

        @Override
        public String map(Integer from) {
            return String.valueOf(from);
        }

        @Override
        public List<String> map(List<Integer> from) {
            ArrayList<String> strings = new ArrayList<>(from.size());
            for (Integer integer : from) {
                strings.add(map(integer));
            }
            return strings;
        }
    }
}
