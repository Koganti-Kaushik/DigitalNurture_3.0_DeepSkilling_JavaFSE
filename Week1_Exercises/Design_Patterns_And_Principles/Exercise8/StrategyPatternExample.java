package Exercise8;

public class StrategyPatternExample {

    public interface PaymentStrategy {
        void pay(double amount);
    }

    public static class CreditCardPayment implements PaymentStrategy {
        private String cardNum;
        private String cardHolder;

        public CreditCardPayment(String cardNum, String cardHolder) {
            this.cardNum = cardNum;
            this.cardHolder = cardHolder;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using Credit Card: " + cardNum);
        }
    }

    public static class PayPalPayment implements PaymentStrategy {
        private String userEmail;

        public PayPalPayment(String userEmail) {
            this.userEmail = userEmail;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using PayPal: " + userEmail);
        }
    }

    public static class PaymentContext {
        private PaymentStrategy currentStrategy;

        public void setPaymentStrategy(PaymentStrategy currentStrategy) {
            this.currentStrategy = currentStrategy;
        }

        public void executePayment(double amount) {
            if (currentStrategy != null) {
                currentStrategy.pay(amount);
            } else {
                System.out.println("The payment strategy has not been set");
            }
        }
    }

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy ccPayment = new CreditCardPayment("9876-5432-1098-7654", "John Smith");
        context.setPaymentStrategy(ccPayment);
        context.executePayment(250.0);

        PaymentStrategy ppPayment = new PayPalPayment("john.smith@example.com");
        context.setPaymentStrategy(ppPayment);
        context.executePayment(500.0);
    }
}
