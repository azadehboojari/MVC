package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.repositories.BookRepository;
import com.codingdojo.mvc.models.Book;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	
	 public List<Book> allBooks() {
	        return bookRepository.findAll();
	    }
	    // creates a book
	 public Book createBook(Book b) {
	        return bookRepository.save(b);
	        }
	    // retrieves a book
	 public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
	 }
	 public Book updateBook(Long id, String title, String desc, String lang, Integer num) {
		 Book bk =bookRepository.findById(id).get();
		  
		 if(bk != null) {
			 bk.setTitle(title);
			 bk.setDescription(desc);
			 bk.setLanguage(lang);
			 bk.setNumberOfPages(num);
			 return bookRepository.save(bk);
		 }else {
			 return null;
		 }
	 }
	 
	 public Book deleteBook(Long id) {
		bookRepository.deleteById(id);
		return null;
	 }
}
