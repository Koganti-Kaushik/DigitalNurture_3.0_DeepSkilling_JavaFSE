package DSAExercise6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryManagementSystem {

    public static class Book {
        private String bookId;
        private String title;
        private String author;

        public Book(String bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public String getBookId() { return bookId; }
        public void setBookId(String bookId) { this.bookId = bookId; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }

        @Override
        public String toString() {
            return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    public static class LibraryOperations {

        public Book BookByTitleLinearSearch(List<Book> bookList, String searchTitle) {
            for (Book book : bookList) {
                if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                    return book;
                }
            }
            return null;
        }

        public Book BookByTitleBinarySearch(List<Book> bookList, String searchTitle) {
            int start = 0;
            int end = bookList.size() - 1;
            while (start <= end) {
                int middle = start + (end - start) / 2;
                Book middleBook = bookList.get(middle);
                int comparison = middleBook.getTitle().compareToIgnoreCase(searchTitle);
                if (comparison == 0) {
                    return middleBook;
                } else if (comparison < 0) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("B007", "Shiv Puran", "Ved Vyas"));
        bookList.add(new Book("B008", "Ramcharitmanas", "Tulsidas"));
        bookList.add(new Book("B009", "Siddhartha", "Hermann Hesse"));

        LibraryOperations libraryOps = new LibraryOperations();

        System.out.println("Initial Collection of Books:");
        for (Book book : bookList) {
            System.out.println(book);
        }

        System.out.println("\nSearching for 'Ramcharitmanas' using linear search:");
        Book foundBook = libraryOps.BookByTitleLinearSearch(bookList, "Ramcharitmanas");
        System.out.println(foundBook != null ? foundBook : "Book not found.");

        Collections.sort(bookList, (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));

        System.out.println("\nBooks Sorted by Title:");
        for (Book book : bookList) {
            System.out.println(book);
        }

        System.out.println("\nSearching for 'Shiv Puran' using binary search:");
        foundBook = libraryOps.BookByTitleBinarySearch(bookList, "Shiv Puran");
        System.out.println(foundBook != null ? foundBook : "Book not found.");
    }
}

