package model;

import exceptions.IDParityException;
import exceptions.IDTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarketplaceTest {

    private Marketplace mp;

    private void setupScenary() {

        mp = new Marketplace(9);

    }

    @Test
    public void testAccess1() {

        setupScenary();

        Person person = new Person(1, "1005891880");

        try {
            mp.attemptAccess(person);
            fail();
        } catch (IDParityException e) {
            fail();
        } catch (IDTypeException e) {
            assertEquals(IDType.TI, person.getIdType());
        }

    }

    @Test
    public void testAccess2() {

        setupScenary();

        Person person = new Person(2, "1005891890");

        try {
            mp.attemptAccess(person);
            fail();
        } catch (IDParityException e) {

        } catch (IDTypeException e) {
            fail();
        }

    }

    @Test
    public void testAccess3() {

        setupScenary();

        Person person = new Person(2, "1005891880");

        try {
            mp.attemptAccess(person);
        } catch (IDParityException | IDTypeException e) {
            fail();
        }

    }

}
