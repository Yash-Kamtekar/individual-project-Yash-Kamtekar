package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DiscoverTest {
    @Test
    public void validDiscoverCard() {
        Card creditCard = new Card("6011000000000000");
        Chain chainDiscover = new Discover();

        assertTrue(chainDiscover.evaluate(creditCard));
    }

    @Test
    public void inValidDiscoverCard() {
        Card creditCard = new Card("6001000000000000");
        Chain chainDiscover = new Discover();

        assertFalse(chainDiscover.evaluate(creditCard));
    }

    @Test
    public void shortLengthDiscoverCard() {
        Card creditCard = new Card("601100000000000");
        Chain chainDiscover = new Discover();

        assertFalse(chainDiscover.evaluate(creditCard));
    }

    @Test
    public void longLengthDiscoverCard() {
        Card creditCard = new Card("601112300000000000");
        Chain chainDiscover = new Discover();

        assertFalse(chainDiscover.evaluate(creditCard));
    }
}
