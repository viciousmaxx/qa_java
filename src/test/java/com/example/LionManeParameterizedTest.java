package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionManeParameterizedTest {
    private final String sex;
    private final Feline feline;
    private final boolean expected;

    public LionManeParameterizedTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
        feline = new Feline();
    }

    @Parameterized.Parameters(name = "{index}: sex = {0}, has mane = {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"foo", false}
        };
    }

    @Test
    public void testLionMane() {
        try {
            Lion lion = new Lion(sex, feline);
            assertEquals(expected, lion.doesHaveMane());
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }
}