public class RazorPay implements PaymentStrategyInterface{
    int commisionRate = 15;

    @Override
    public boolean pay(int amount) {
        System.out.println("Payment done via RAZORPAY ---> " + amount);
        // Do processing
        return true;
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
