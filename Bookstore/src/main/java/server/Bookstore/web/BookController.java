package server.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import server.Bookstore.domain.Book;
import server.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/booklist")
	public String booklist(Model model) {
		model.addAttribute("booklist", repository.findAll());
		return "booklist";
	}

	@GetMapping("/addBook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
	@PostMapping("/addBook")
	public String addBook (@ModelAttribute Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	repository.deleteById(bookId);
	return "redirect:../booklist";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		return "editBook";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
}