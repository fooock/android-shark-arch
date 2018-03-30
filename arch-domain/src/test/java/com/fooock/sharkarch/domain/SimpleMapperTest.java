package com.fooock.sharkarch.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class SimpleMapperTest {

    private IntegerSimpleMapper mIntegerSimpleMapper;

    @Before
    public void setUp() {
        mIntegerSimpleMapper = new IntegerSimpleMapper();
    }

    @Test
    public void testMapper() {
        assertEquals("1", mIntegerSimpleMapper.map(1));
    }

    @After
    public void tearDown() {
        mIntegerSimpleMapper = null;
    }

    /**
     *
     */
    static class IntegerSimpleMapper implements SimpleMapper<Integer, String> {

        @Override
        public String map(Integer from) {
            return String.valueOf(from);
        }
    }
}
