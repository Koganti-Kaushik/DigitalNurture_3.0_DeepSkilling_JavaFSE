package Exercise9;
public class CommandPatternExample {

    public interface Command {
        void execute();
    }

    public static class Light {
        public void turnOn() {
            System.out.println("Light is now ON");
        }

        public void turnOff() {
            System.out.println("Light is now OFF");
        }
    }

    public static class LightOnCommand implements Command {
        private Light lightDevice;

        public LightOnCommand(Light lightDevice) {
            this.lightDevice = lightDevice;
        }

        @Override
        public void execute() {
            lightDevice.turnOn();
        }
    }

    public static class LightOffCommand implements Command {
        private Light lightDevice;

        public LightOffCommand(Light lightDevice) {
            this.lightDevice = lightDevice;
        }

        @Override
        public void execute() {
            lightDevice.turnOff();
        }
    }

    public static class RemoteControl {
        private Command currentCommand;

        public void setCommand(Command currentCommand) {
            this.currentCommand = currentCommand;
        }

        public void pressButton() {
            if (currentCommand != null) {
                currentCommand.execute();
            } else {
                System.out.println("No command has been set");
            }
        }
    }

    public static void main(String[] args) {
        Light kitchenLight = new Light();
        Command turnOnLight = new LightOnCommand(kitchenLight);
        Command turnOffLight = new LightOffCommand(kitchenLight);
        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOnLight);
        remote.pressButton();

        remote.setCommand(turnOffLight);
        remote.pressButton();
    }
}
