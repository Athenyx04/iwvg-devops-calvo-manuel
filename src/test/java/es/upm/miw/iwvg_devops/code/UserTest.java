package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private User user;

    @BeforeEach
    void before() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        user = new User("1", "Manuel", "Calvo", fractions);
    }

    @Test
    void testUserWithParams() {
        assertEquals("1", user.getId());
        assertEquals("Manuel", user.getName());
        assertEquals("Calvo", user.getFamilyName());
        assertEquals(1, user.getFractions().size());
    }

    @Test
    void testUser() {
        user = new User();
        assertEquals(0, user.getFractions().size());
    }

    @Test
    void testSetName() {
        user.setName("Olivia");
        assertEquals("Olivia", user.getName());
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("Martín");
        assertEquals("Martín", user.getFamilyName());
    }

    @Test
    void testSetFraction() {
        List<Fraction> newFractions = new ArrayList<>();
        Fraction newFraction = new Fraction(5, 6);
        newFractions.add(newFraction);
        user.setFractions(newFractions);
        assertEquals(1, user.getFractions().size());
        assertEquals(newFraction, user.getFractions().get(0));
    }

    @Test
    void testAddFraction() {
        Fraction newFraction = new Fraction(5, 6);
        user.addFraction(newFraction);
        assertEquals(2, user.getFractions().size());
        assertEquals(newFraction, user.getFractions().get(1));
    }

    @Test
    void testFullName() {
        assertEquals("Manuel Calvo", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("M.", user.initials());
    }

    @Test
    void testToString() {
        String expectedToString = "User{id='1', name='Manuel', familyName='Calvo', fractions=[1/2]}";
        assertEquals(expectedToString, user.toString());
    }
}
