package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {
    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        assertEquals(
                List.of("Torres"),
                new Searches().findUserFamilyNameByAllNegativeSignFractionDistinct().collect(Collectors.toList())
        );
    }

    @Test
    void testFindFractionDivisionByUserId() {
        assertEquals(
                new Fraction(12,8).toString(),
                new Searches().findFractionDivisionByUserId("7").toString()
        );
        assertEquals(
                new Fraction(120,-8).toString(),
                new Searches().findFractionDivisionByUserId("2").toString()
        );
    }

    @Test
    void testFindFractionAdditionByUserId() {
        assertEquals(
                new Fraction(16,-8).toString(),
                new Searches().findFractionAdditionByUserId("4").toString()
        );
    }

    @Test
    void testFindUserIdBySomeProperFraction() {
        assertEquals(
                List.of("1", "2", "3", "5", "7"),
                new Searches().findUserIdBySomeProperFraction().collect(Collectors.toList())
        );
    }
}
