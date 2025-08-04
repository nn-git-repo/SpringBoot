package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.Category;
import com.example.library.entity.Reader;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.CategoryRepository;
import com.example.library.repository.ReaderRepository;


@RestController
@RequestMapping("/api")
public class LibraryController {

	
	 @Autowired
	    private ReaderRepository readerRepo;

	    @Autowired
	    private BookRepository bookRepo;

	    @Autowired
	    private CategoryRepository categoryRepo;

	    @Autowired
	    private AuthorRepository authorRepo;

	    // ----------------- Readers -------------------
	    @PostMapping("/readers")
	    public Reader addReader(@RequestBody Reader reader) {
	        return readerRepo.save(reader);
	    }

	    @GetMapping("/readers")
	    public List<Reader> getAllReaders() {
	        return readerRepo.findAll();
	    }
	    
	    @PutMapping("/readers/{id}")
	    public Reader updateReader(@PathVariable Long id, @RequestBody Reader updatedReader) {
	        return readerRepo.findById(id).map(reader -> {
	            reader.setName(updatedReader.getName());
	            reader.setEmail(updatedReader.getEmail());
	            return readerRepo.save(reader);
	        }).orElseThrow(() -> new RuntimeException("Reader not found with id " + id));
	    }
	    
	    
	    @DeleteMapping("/readers/{id}")
	    public String deleteReader(@PathVariable Long id) {
	        readerRepo.deleteById(id);
	        return "Reader deleted with id " + id;
	    }



	    // ----------------- Books -------------------
	    @PostMapping("/books")
	    public Book addBook(@RequestBody Book book) {
	        return bookRepo.save(book);
	    }

	    @GetMapping("/books")
	    public List<Book> getAllBooks() {
	        return bookRepo.findAll();
	    }

	    @PutMapping("/books/{id}")
	    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
	        return bookRepo.findById(id).map(book -> {
	            book.setTitle(updatedBook.getTitle());
	            book.setPublishDate(updatedBook.getPublishDate());
	            book.setReader(updatedBook.getReader());
	            book.setCategory(updatedBook.getCategory());
	            book.setAuthor(updatedBook.getAuthor());
	            return bookRepo.save(book);
	        }).orElseThrow(() -> new RuntimeException("Book not found with id " + id));
	    }

	    @DeleteMapping("/books/{id}")
	    public String deleteBook(@PathVariable Long id) {
	        bookRepo.deleteById(id);
	        return "Book deleted with id " + id;
	    }

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    // ----------------- Categories -------------------
	    @PostMapping("/categories")
	    public Category addCategory(@RequestBody Category category) {
	        return categoryRepo.save(category);
	    }

	    @GetMapping("/categories")
	    public List<Category> getAllCategories() {
	        return categoryRepo.findAll();
	    }
	    
	    
	    @PutMapping("/categories/{id}")
	    public Category updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
	        return categoryRepo.findById(id).map(category -> {
	            category.setName(updatedCategory.getName());
	            return categoryRepo.save(category);
	        }).orElseThrow(() -> new RuntimeException("Category not found with id " + id));
	    }

	    
	    @DeleteMapping("/categories/{id}")
	    public String deleteCategory(@PathVariable Long id) {
	        categoryRepo.deleteById(id);
	        return "Category deleted with id " + id;
	    }

	    
	    
	    
	    
	    
	    
	    
	    
	    

	    // ----------------- Authors -------------------
	    @PostMapping("/authors")
	    public Author addAuthor(@RequestBody Author author) {
	        return authorRepo.save(author);
	    }

	    @GetMapping("/authors")
	    public List<Author> getAllAuthors() {
	        return authorRepo.findAll();
	    }
	
	    
	    @PutMapping("/authors/{id}")
	    public Author updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
	        return authorRepo.findById(id).map(author -> {
	            author.setName(updatedAuthor.getName());
	            return authorRepo.save(author);
	        }).orElseThrow(() -> new RuntimeException("Author not found with id " + id));
	    }

	    
	    
	    
	    @DeleteMapping("/authors/{id}")
	    public String deleteAuthor(@PathVariable Long id) {
	        authorRepo.deleteById(id);
	        return "Author deleted with id " + id;
	    }

	
	
	
}
