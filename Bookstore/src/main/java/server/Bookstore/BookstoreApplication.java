package server.Bookstore;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import server.Bookstore.domain.Book;
import server.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean 
	public CommandLineRunner demo(BookRepository repo) {
		return(args) -> {
			log.info("inserting books");
			repo.save(new Book("Clean code", "Robert Cecil Martin ", "2008", "9780132350884", 29.09));
			repo.save(new Book("The pramatic programmer", "David Thomas", "2019", "0135957052", 33.99));

			log.info("fetching all books");
			for(Book book : repo.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
