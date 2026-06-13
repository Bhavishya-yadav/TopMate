public class Stripe implements PaymentStrategyInterface {
    int commisionRate = 10;

    @Override
    public boolean pay(int amount) {
        System.out.println("Payment done via STRIPE ---> " + amount);
        // Do processing
        return true;
    }



}
