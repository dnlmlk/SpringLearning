package dnl.tst.springlearning.controller;

import dnl.tst.springlearning.model.Author;
import dnl.tst.springlearning.model.Book;
import dnl.tst.springlearning.service.AuthorService;
import dnl.tst.springlearning.service.AuthorServiceImpl;
import dnl.tst.springlearning.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/author")
@RestController
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Author> getAuthors() {
        return authorService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{authorId}")
    public Author getAuthorById(@PathVariable("authorId") Long id) {
        return authorService.findById(id);
    }
}
