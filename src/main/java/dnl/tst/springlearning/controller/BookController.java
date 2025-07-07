package dnl.tst.springlearning.controller;

import dnl.tst.springlearning.model.Book;
import dnl.tst.springlearning.model.Publisher;
import dnl.tst.springlearning.model.Sample;
import dnl.tst.springlearning.service.BookService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequestMapping("/api/book")
@RestController
public class BookController {
    private final BookService bookService;

    public BookController(@Qualifier("ScientificBookService") BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Book> getBooks() {
        return bookService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{bookId}")
    public Book getBookById(@PathVariable("bookId") Long id) {
        return bookService.findById(id);
    }

    @PostMapping("add")
    public ResponseEntity addBook(@RequestBody Book book) {
        log.info(book.toString());
        log.info(book.getPublisher().getName());
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
