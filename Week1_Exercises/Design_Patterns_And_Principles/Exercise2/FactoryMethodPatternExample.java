package Exercise2;

public class FactoryMethodPatternExample {

    public interface File {
        void load();
        void store();
        void exit();
    }

    public static class TextFile implements File {
        @Override
        public void load() {
            System.out.println("Text File is now loaded.");
        }
        @Override
        public void store() {
            System.out.println("Text File has been stored.");
        }
        @Override
        public void exit() {
            System.out.println("Text File is now closed.");
        }
    }

    public static class SpreadsheetFile implements File {
        @Override
        public void load() {
            System.out.println("Spreadsheet File is now loaded.");
        }
        @Override
        public void store() {
            System.out.println("Spreadsheet File has been stored.");
        }
        @Override
        public void exit() {
            System.out.println("Spreadsheet File is now closed.");
        }
    }

    public static class PresentationFile implements File {
        @Override
        public void load() {
            System.out.println("Presentation File is now loaded.");
        }
        @Override
        public void store() {
            System.out.println("Presentation File has been stored.");
        }
        @Override
        public void exit() {
            System.out.println("Presentation File is now closed.");
        }
    }

    public abstract static class FileFactory {
        public abstract File createFile();
    }

    public static class TextFileFactory extends FileFactory {
        @Override
        public File createFile() {
            return new TextFile();
        }
    }

    public static class SpreadsheetFileFactory extends FileFactory {
        @Override
        public File createFile() {
            return new SpreadsheetFile();
        }
    }

    public static class PresentationFileFactory extends FileFactory {
        @Override
        public File createFile() {
            return new PresentationFile();
        }
    }

    public static void main(String[] args) {
        FileFactory textFileFactory = new TextFileFactory();
        File textFile = textFileFactory.createFile();
        textFile.load();
        textFile.store();
        textFile.exit();

        FileFactory spreadsheetFileFactory = new SpreadsheetFileFactory();
        File spreadsheetFile = spreadsheetFileFactory.createFile();
        spreadsheetFile.load();
        spreadsheetFile.store();
        spreadsheetFile.exit();

        FileFactory presentationFileFactory = new PresentationFileFactory();
        File presentationFile = presentationFileFactory.createFile();
        presentationFile.load();
        presentationFile.store();
        presentationFile.exit();
    }
}

