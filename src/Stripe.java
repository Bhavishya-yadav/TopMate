public class Stripe implements PaymentStrategyInterface {
    int commisionRate = 10;

    @Override
    public void pay(int amount) {
        System.out.println("Payment done via STRIPE ---> " + amount);
    }



}
