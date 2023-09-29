package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchesTest {
    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        assertEquals(
                List.of("Torres"),
                new Searches().findUserFamilyNameByAllNegativeSignFractionDistinct().collect(Collectors.toList())
        );
    }
}
