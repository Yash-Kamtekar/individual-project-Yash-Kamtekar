package test;

public class Discover implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {

        this.nextInChain = nextChain;

    }

    @Override
    public Boolean evaluate(Card creditCardDetail) {

        String creditCard = creditCardDetail.getCreditCard();
        int lengthCreditCard = creditCard.length();

        if (lengthCreditCard == 16 && creditCard.startsWith("6011")) {

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
