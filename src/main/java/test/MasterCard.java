package test;

public class MasterCard implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {

        this.nextInChain = nextChain;

    }

    @Override
    public Boolean evaluate(Card creditCardDetail) {

        String creditCard = creditCardDetail.getCreditCard();
        int lengthCreditCard = creditCard.length();
        int secondDigit = creditCard.charAt(1) - '0';

        if (lengthCreditCard == 16 && creditCard.charAt(0) == '5' && (secondDigit >= 1 && secondDigit <= 5)) {

            return true;

        } else {

            if (nextInChain != null) {

                return nextInChain.evaluate(creditCardDetail);

            } else {

                return false;

            }

        }

    }
}
