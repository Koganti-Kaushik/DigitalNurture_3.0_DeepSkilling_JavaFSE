package Exercise3;

public class BuilderPatternExample {

    public static class Laptop {
        private String cpu;
        private String ram;
        private String storage;
        private boolean hasDedicatedGraphics;
        private boolean hasWiFi;

        private Laptop(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.hasDedicatedGraphics = builder.hasDedicatedGraphics;
            this.hasWiFi = builder.hasWiFi;
        }

        public String getCpu() {
            return cpu;
        }

        public String getRam() {
            return ram;
        }

        public String getStorage() {
            return storage;
        }

        public boolean isHasDedicatedGraphics() {
            return hasDedicatedGraphics;
        }

        public boolean isHasWiFi() {
            return hasWiFi;
        }

        public static class Builder {
            private String cpu;
            private String ram;
            private String storage;
            private boolean hasDedicatedGraphics;
            private boolean hasWiFi;

            public Builder(String cpu, String ram, String storage) {
                this.cpu = cpu;
                this.ram = ram;
                this.storage = storage;
            }

            public Builder setHasDedicatedGraphics(boolean hasDedicatedGraphics) {
                this.hasDedicatedGraphics = hasDedicatedGraphics;
                return this;
            }

            public Builder setHasWiFi(boolean hasWiFi) {
                this.hasWiFi = hasWiFi;
                return this;
            }

            public Laptop build() {
                return new Laptop(this);
            }
        }
    }

    public static void main(String[] args) {
        Laptop gamingLaptop = new Laptop.Builder("AMD Ryzen 9", "32GB", "1TB SSD")
                .setHasDedicatedGraphics(true)
                .setHasWiFi(true)
                .build();

        Laptop businessLaptop = new Laptop.Builder("Intel Core i7", "16GB", "512GB HDD")
                .setHasDedicatedGraphics(false)
                .setHasWiFi(true)
                .build();

        System.out.println("Gaming Laptop Specifications:");
        System.out.println("CPU: " + gamingLaptop.getCpu());
        System.out.println("RAM: " + gamingLaptop.getRam());
        System.out.println("Storage: " + gamingLaptop.getStorage());
        System.out.println("Dedicated Graphics: " + gamingLaptop.isHasDedicatedGraphics());
        System.out.println("WiFi Enabled: " + gamingLaptop.isHasWiFi());

        System.out.println("\nBusiness Laptop Specifications:");
        System.out.println("CPU: " + businessLaptop.getCpu());
        System.out.println("RAM: " + businessLaptop.getRam());
        System.out.println("Storage: " + businessLaptop.getStorage());
        System.out.println("Dedicated Graphics: " + businessLaptop.isHasDedicatedGraphics());
        System.out.println("WiFi Enabled: " + businessLaptop.isHasWiFi());
    }
}
