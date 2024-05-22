package javacoding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Book {
	
	private String title;
	private int year;
	private double price;

	public Book(String title, int year, double price) {
		super();
		this.title = title;
		this.year = year;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", year=" + year + ", price=" + price + "]";
	}

	public static void main(String[] args) {
		
		List<Book> list = new ArrayList();
		list.add(new Book("Book1",2002,55));
		list.add(new Book("Book2",1998,30));
		list.add(new Book("Book3",2005,40));
		list.add(new Book("Book4",2010,60));
		
		//titles of books published after 2000
		List<String> titles = list.stream().filter(b->b.getYear()>2000).map(Book::getTitle).collect(Collectors.toList());
		System.out.println(titles);
		
		//Calculate the total price of all books
		double total_price = list.stream().mapToDouble(Book::getPrice).sum();
		System.out.println(total_price);
		
		//book with the highest price
		Book max_price = list.stream().max(Comparator.comparing(Book::getPrice)).get();
		System.out.println(max_price);
		
		//new list with books priced less than $40
		List<Book> books40 = list.stream().filter(b->b.getPrice()<40).collect(Collectors.toList());
		System.out.println(books40);
		
	}

}
