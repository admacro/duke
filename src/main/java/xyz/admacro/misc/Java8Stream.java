package xyz.admacro.misc;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * This class demonstrates Stream API in Java 8.
 */
public class Java8Stream {
    public static void main(String args[]) {
        List<Integer> list = List.of(1, 4, 9);

        // lambda expression
        Stream<Integer> stream = list.stream();
        stream.map((Integer i) -> i + 1) // non-terminal operation
            .forEach(re -> System.out.println(re)); // terminal operation

        // method reference
        stream = list.stream();
        stream.map(Math::sqrt).forEach(System.out::println);

        // reduce
        double sum = list.stream()
            .map(Math::sqrt)
            .reduce(0d, (t, v) -> t + v);
        System.out.println("map reduce sum is " + sum);

        // Objects
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java", "James"));
        books.add(new Book("Ruby", "Martz"));
        books.add(new Book("Go", "Rob"));
        books.stream()          // returns Stream<Book>
            .map(b -> b.getTitle()) // returns Stream<String>
            .filter(t -> t.length() < 4) // returns Stream<String>
            .forEach(System.out::println);
    }

    static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}
    }
}
