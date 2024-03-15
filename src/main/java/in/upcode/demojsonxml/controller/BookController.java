package in.upcode.demojsonxml.controller;

import in.upcode.demojsonxml.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping("/single")
    public Book getSingleBook() {
        Book book = new Book();
        book.setTitle("The Catcher in the Rye");
        book.setAuthor("J.D. Salinger");
        return book;
    }

    @GetMapping("")
    public List<Book> getBookList() {
        Book book1 = new Book();
        book1.setTitle("To Kill a Mockingbird");
        book1.setAuthor("Harper Lee");

        Book book2 = new Book();
        book2.setTitle("1984");
        book2.setAuthor("George Orwell");

        return Arrays.asList(book1, book2);
    }

    @GetMapping("/map")
    public Map<String, Book> getBookMap() {
        Book book1 = new Book();
        book1.setTitle("Pride and Prejudice");
        book1.setAuthor("Jane Austen");

        Book book2 = new Book();
        book2.setTitle("The Great Gatsby");
        book2.setAuthor("F. Scott Fitzgerald");

        Map<String, Book> bookMap = new HashMap<>();
        bookMap.put("book1", book1);
        bookMap.put("book2", book2);

        return bookMap;
    }
}
