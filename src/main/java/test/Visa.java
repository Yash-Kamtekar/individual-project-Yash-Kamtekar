package test;

public class Visa implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {

        this.nextInChain = nextChain;
    }

    @Override
    public Boolean evaluate(Card creditCardDetail) {

        String creditCard = creditCardDetail.getCreditCard();
        int lengthCreditCard = creditCard.length();

        if ((lengthCreditCard == 13 || lengthCreditCard == 16) && creditCard.charAt(0) == '4') {

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
