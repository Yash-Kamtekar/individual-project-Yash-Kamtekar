package test;

public class Amex implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {

        this.nextInChain = nextChain;

    }

    @Override
    public Boolean evaluate(Card creditCardDetail) {

        String creditCard = creditCardDetail.getCreditCard();
        int lengthCreditCard = creditCard.length();
        char secondDigit = creditCard.charAt(1);

        if (lengthCreditCard == 15 && creditCard.charAt(0) == '3' && (secondDigit == '4' || secondDigit == '7')) {

            return true;

        } else {

            return false;

        }
    }
}
