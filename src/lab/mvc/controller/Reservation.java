package lab.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;

import lab.mvc.model.Book;

public class Reservation {
	
	HashMap<String, Boolean> books;

	public Reservation() {
		books = new HashMap();
		books.put("Spider-Man", true);
		books.put("Avengers", false);
		books.put("Spider-Man vs Avengers", false);
		books.put("Batman", true);
		books.put("Superman", true);
		books.put("Batman vs Superman", true);
	}
	
	public ArrayList<Book> bookSearch(String bookName) {
		ArrayList<Book> bookResults = new ArrayList<Book>();
		for (HashMap.Entry<String, Boolean> Hashbook : books.entrySet()) {
			String key = Hashbook.getKey();
			Boolean value = Hashbook.getValue();
			
			if (key.toLowerCase().contains(bookName.toLowerCase())) {
				Book book = new Book();
				book.setName(key);
				book.setRented(value);
				bookResults.add(book);
			}
		}
		return bookResults;
	}

}
