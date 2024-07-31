package Exercise7;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {

    public interface Stock {
        void registerObserver(Observer observer);
        void deregisterObserver(Observer observer);
        void notifyObservers();
    }

    public static class StockMarket implements Stock {
        private List<Observer> observerList = new ArrayList<>();
        private double currentPrice;

        @Override
        public void registerObserver(Observer observer) {
            observerList.add(observer);
        }

        @Override
        public void deregisterObserver(Observer observer) {
            observerList.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observerList) {
                observer.update(currentPrice);
            }
        }

        public void setStockPrice(double price) {
            this.currentPrice = price;
            notifyObservers();
        }
    }

    public interface Observer {
        void update(double price);
    }

    public static class MobileApp implements Observer {
        private String applicationName;

        public MobileApp(String applicationName) {
            this.applicationName = applicationName;
        }

        @Override
        public void update(double price) {
            System.out.println(applicationName + " received an update: Stock price is now " + price);
        }
    }

    public static class WebApp implements Observer {
        private String applicationName;

        public WebApp(String applicationName) {
            this.applicationName = applicationName;
        }

        @Override
        public void update(double price) {
            System.out.println(applicationName + " received an update: Stock price is now " + price);
        }
    }

    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileAppOne = new MobileApp("Mobile Tracker 1");
        Observer mobileAppTwo = new MobileApp("Mobile Tracker 2");
        Observer webApp = new WebApp("Web Tracker");

        stockMarket.registerObserver(mobileAppOne);
        stockMarket.registerObserver(mobileAppTwo);
        stockMarket.registerObserver(webApp);

        System.out.println("Stock price updated to 99.5");
        stockMarket.setStockPrice(99.5);

        System.out.println("Unregistering Mobile Tracker 1");
        stockMarket.deregisterObserver(mobileAppOne);

        System.out.println("Stock price updated to 105.3");
        stockMarket.setStockPrice(105.3);
    }
}
