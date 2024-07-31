package Exercise4;

public class AdapterPatternExample {

    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    public static class Payoneer {
        public void sendFunds(double amount) {
            System.out.println("Payoneer: Sending $" + amount);
        }
    }

    public static class Braintree {
        public void performTransaction(double amount) {
            System.out.println("Braintree: Performing transaction of $" + amount);
        }
    }

    public static class PayoneerAdapter implements PaymentProcessor {
        private Payoneer payoneer;

        public PayoneerAdapter(Payoneer payoneer) {
            this.payoneer = payoneer;
        }

        @Override
        public void processPayment(double amount) {
            payoneer.sendFunds(amount);
        }
    }

    public static class BraintreeAdapter implements PaymentProcessor {
        private Braintree braintree;

        public BraintreeAdapter(Braintree braintree) {
            this.braintree = braintree;
        }

        @Override
        public void processPayment(double amount) {
            braintree.performTransaction(amount);
        }
    }

    public static void main(String[] args) {
        Payoneer payoneer = new Payoneer();
        Braintree braintree = new Braintree();

        PaymentProcessor payoneerProcessor = new PayoneerAdapter(payoneer);
        PaymentProcessor braintreeProcessor = new BraintreeAdapter(braintree);

        System.out.println("Processing payments:");
        payoneerProcessor.processPayment(500.0);
        braintreeProcessor.processPayment(600.0);
    }
}
