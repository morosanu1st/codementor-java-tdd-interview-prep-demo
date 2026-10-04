package com.codementor.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests ordered like a live red-green-refactor loop in a pair session.
 */
class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("Red→Green: empty input returns 0")
    void emptyReturnsZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    @DisplayName("Green: single number")
    void singleNumber() {
        assertEquals(7, calculator.add("7"));
    }

    @Test
    @DisplayName("Green: two comma-separated numbers")
    void twoNumbersComma() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    @DisplayName("Refactor-friendly: newlines also separate")
    void newlinesAsSeparators() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    @DisplayName("Custom delimiter header")
    void customDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    @DisplayName("Negatives rejected with message listing all")
    void negativesThrow() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.add("1,-2,3,-4")
        );
        assertTrue(ex.getMessage().contains("-2"));
        assertTrue(ex.getMessage().contains("-4"));
    }
}
