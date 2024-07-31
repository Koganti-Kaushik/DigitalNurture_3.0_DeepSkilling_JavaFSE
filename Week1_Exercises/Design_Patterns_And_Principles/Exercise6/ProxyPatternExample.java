package Exercise6;

public class ProxyPatternExample {

    public interface Image {
        void show();
    }

    public static class RealImage implements Image {
        private String imagePath;

        public RealImage(String imagePath) {
            this.imagePath = imagePath;
            fetchImageFromServer();
        }

        private void fetchImageFromServer() {
            System.out.println("Downloading image from server: " + imagePath);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void show() {
            System.out.println("Displaying image from " + imagePath);
        }
    }

    public static class ProxyImage implements Image {
        private String imagePath;
        private RealImage realImageInstance;

        public ProxyImage(String imagePath) {
            this.imagePath = imagePath;
        }

        @Override
        public void show() {
            if (realImageInstance == null) {
                realImageInstance = new RealImage(imagePath);
            }
            realImageInstance.show();
        }
    }

    public static void main(String[] args) {
        Image firstImage = new ProxyImage("http://example.com/pic1.png");
        Image secondImage = new ProxyImage("http://example.com/pic2.png");

        System.out.println("Loading firstImage:");
        firstImage.show();
        System.out.println("Loading firstImage again:");
        firstImage.show();

        System.out.println("Loading secondImage:");
        secondImage.show();
        System.out.println("Loading secondImage again:");
        secondImage.show();
    }
}
