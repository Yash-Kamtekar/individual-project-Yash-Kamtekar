package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class VisaTest {
    @Test
    public void inValidVisaCard() {
        Card creditCard = new Card("6011000000000000");
        Chain chainVisa = new Visa();

        assertFalse(chainVisa.evaluate(creditCard));
    }

    @Test
    public void validVisaCard() {
        Card creditCard = new Card("4001000000000000");
        Chain chainVisa = new Visa();

        assertTrue(chainVisa.evaluate(creditCard));
    }

    @Test
    public void shortLengthVisaCard() {
        Card creditCard = new Card("4001004560");
        Chain chainVisa = new Visa();

        assertFalse(chainVisa.evaluate(creditCard));
    }

    @Test
    public void longLengthVisaCard() {
        Card creditCard = new Card("400123000000567892");
        Chain chainVisa = new Visa();

        assertFalse(chainVisa.evaluate(creditCard));
    }
}
