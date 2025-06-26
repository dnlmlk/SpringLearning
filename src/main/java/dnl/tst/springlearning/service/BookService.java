package dnl.tst.springlearning.service;

import dnl.tst.springlearning.model.Author;
import dnl.tst.springlearning.model.Book;
import dnl.tst.springlearning.model.Publisher;

import java.util.List;
import java.util.Set;

public interface BookService {
    public Iterable<Book> findAll();
    public Book findById(Long id);
    public void addBook(String name, String isbn, Publisher publisher, Set<Author> authors);
}
