package srp.com.bharti.app.service;

import java.util.ArrayList;
import java.util.List;

import srp.com.bharti.app.model.Book;

public class SampleData {
	public List<Book> getBooks() {
		List<Book> list1 = new ArrayList<>();
		list1.add(new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone"));
		list1.add(new Book("George Orwell", "Animal Farm"));
		list1.add(new Book("Harper Lee", "To Kill a Mockingbird"));
		list1.add(new Book("Jane Austen", "Pride and Prejudice"));
		list1.add(new Book("Ernest Hemingway", "The Old Man and the Sea"));
		// Create Book objects for List2
		List<Book> list2 = new ArrayList<>();
		list2.add(new Book("Ray Bradbury", "Fahrenheit 451"));
		list2.add(new Book("Aldous Huxley", "Brave New World"));
		list2.add(new Book("Agatha Christie", "Murder on the Orient Express"));
		list2.add(new Book("F. Scott Fitzgerald", "The Great Gatsby"));
		list2.add(new Book("Maya Angelou", "I Know Why the Caged Bird Sings"));
		List<Book> allBooks = new ArrayList<>();
		allBooks.addAll(list1);
		allBooks.addAll(list2);
		return allBooks;
	}
}
