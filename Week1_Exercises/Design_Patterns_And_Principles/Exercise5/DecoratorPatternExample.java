package Exercise5;

public class DecoratorPatternExample {

    public interface Communicator {
        void deliver(String content);
    }

    public static class BasicEmailCommunicator implements Communicator {
        @Override
        public void deliver(String content) {
            System.out.println("Email delivered: " + content);
        }
    }

    public abstract static class CommunicatorDecorator implements Communicator {
        protected Communicator communicator;

        public CommunicatorDecorator(Communicator communicator) {
            this.communicator = communicator;
        }

        @Override
        public void deliver(String content) {
            communicator.deliver(content);
        }
    }

    public static class SMSDecorator extends CommunicatorDecorator {
        public SMSDecorator(Communicator communicator) {
            super(communicator);
        }

        @Override
        public void deliver(String content) {
            super.deliver(content);
            sendSMS(content);
        }

        private void sendSMS(String content) {
            System.out.println("SMS delivered: " + content);
        }
    }

    public static class SlackDecorator extends CommunicatorDecorator {
        public SlackDecorator(Communicator communicator) {
            super(communicator);
        }

        @Override
        public void deliver(String content) {
            super.deliver(content);
            sendSlack(content);
        }

        private void sendSlack(String content) {
            System.out.println("Slack message delivered: " + content);
        }
    }

    public static void main(String[] args) {
        Communicator emailCommunicator = new BasicEmailCommunicator();
        Communicator smsCommunicator = new SMSDecorator(emailCommunicator);
        Communicator slackCommunicator = new SlackDecorator(smsCommunicator);

        System.out.println("Sending message through all channels:");
        slackCommunicator.deliver("This is a test message.");
    }
}
