package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AmexTest {
    @Test
    public void validAmexCard() {
        Card creditCard = new Card("341109000000000");
        Chain chainAmex = new Amex();

        assertTrue(chainAmex.evaluate(creditCard));
        assertTrue(chainAmex.evaluate(new Card("371109008002000")));
    }

    @Test
    public void inValidAmexCard() {
        Card creditCard = new Card("351109000000000");
        Chain chainAmex = new Amex();

        assertFalse(chainAmex.evaluate(creditCard));
    }

    @Test
    public void shortLengthAmexCard() {
        Card creditCard = new Card("3411090000000");
        Chain chainAmex = new Amex();

        assertFalse(chainAmex.evaluate(creditCard));
    }

    @Test
    public void longLengthAmexCard() {
        Card creditCard = new Card("341109000012345678");
        Chain chainAmex = new Amex();

        assertFalse(chainAmex.evaluate(creditCard));
    }
}
