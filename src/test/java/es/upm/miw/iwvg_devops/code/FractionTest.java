package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FractionTest {
    private Fraction fraction;

    @BeforeEach
    void before() {
        fraction = new Fraction(3, 4);
    }

    @Test
    void testFractionWithParams() {
        assertEquals(3, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    void testFraction() {
        fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testSetNumerator() {
        fraction.setNumerator(5);
        assertEquals(5, fraction.getNumerator());
    }

    @Test
    void testSetDenominator() {
        fraction.setDenominator(6);
        assertEquals(6, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.75, fraction.decimal(), 0.0001);
    }

    @Test
    void testToString() {
        String expectedToString = "Fraction{numerator=3, denominator=4}";
        assertEquals(expectedToString, fraction.toString());
    }

    @Test
    void testIsProper() {
        Fraction improperFraction = new Fraction(10, 5);
        assertTrue(fraction.isProper());
        assertFalse(improperFraction.isProper());
    }

    @Test
    void testIsImproper() {
        Fraction improperFraction = new Fraction(10, 5);
        assertFalse(fraction.isImproper());
        assertTrue(improperFraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction equivalentFraction = new Fraction(6, 8);
        Fraction nonEquivalentFraction = new Fraction(10, 5);
        assertTrue(fraction.isEquivalent(equivalentFraction));
        assertFalse(fraction.isEquivalent(nonEquivalentFraction));
    }

    @Test
    void testAdd() {
        Fraction result = fraction.add(new Fraction(1, 2));
        assertEquals(10, result.getNumerator());
        assertEquals(8, result.getDenominator());
    }

    @Test
    void testMultiply() {
        Fraction result = fraction.multiply(new Fraction(2, 3));
        assertEquals(6, result.getNumerator());
        assertEquals(12, result.getDenominator());
    }

    @Test
    void testDivide() {
        Fraction result = fraction.divide(new Fraction(2, 3));
        assertEquals(9, result.getNumerator());
        assertEquals(8, result.getDenominator());
    }
}
