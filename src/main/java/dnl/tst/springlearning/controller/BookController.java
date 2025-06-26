package dnl.tst.springlearning.controller;

import dnl.tst.springlearning.model.Book;
import dnl.tst.springlearning.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/book")
@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Book> getBooks(Model model) {
        return bookService.findAll();
    }
}
