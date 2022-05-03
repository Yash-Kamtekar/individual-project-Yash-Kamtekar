package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class MasterCardTest {
    @Test
    public void inValidMasterCard() {
        Card creditCard = new Card("6011000000000000");
        Chain chainMasterCard = new MasterCard();

        assertFalse(chainMasterCard.evaluate(creditCard));
    }

    @Test
    public void validMasterCard() {
        Card creditCard = new Card("5101000000000000");
        Chain chainMasterCard = new MasterCard();

        assertTrue(chainMasterCard.evaluate(creditCard));
        assertTrue(chainMasterCard.evaluate(new Card("5201000000001234")));
        assertTrue(chainMasterCard.evaluate(new Card("5301000000009876")));
        assertTrue(chainMasterCard.evaluate(new Card("5401579000009876")));
        assertTrue(chainMasterCard.evaluate(new Card("5501091820001234")));
    }

    @Test
    public void shortLengthMasterCard() {
        Card creditCard = new Card("5200100000000");
        Chain chainMasterCard = new MasterCard();

        assertFalse(chainMasterCard.evaluate(creditCard));
    }

    @Test
    public void longLengthMasterCard() {
        Card creditCard = new Card("521100000000000");
        Chain chainMasterCard = new MasterCard();

        assertFalse(chainMasterCard.evaluate(creditCard));
    }
}
