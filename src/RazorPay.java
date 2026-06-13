public class RazorPay implements PaymentStrategyInterface{
    int commisionRate = 15;

    @Override
    public void pay(int amount) {
        System.out.println("Payment done via RAZORPAY ---> " + amount);
    }
}

/*

ChatHandler {
    Interface freshchat;

    ChatHandler (Interface interface){
        freshchat.messgae()
    }
}

FreshChatHandler() {
    pay() {
    }
}

*/
