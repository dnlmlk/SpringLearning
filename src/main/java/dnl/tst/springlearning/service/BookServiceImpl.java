package dnl.tst.springlearning.service;

import dnl.tst.springlearning.model.Author;
import dnl.tst.springlearning.model.Book;
import dnl.tst.springlearning.model.Publisher;
import dnl.tst.springlearning.repository.BookRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Set;

@Primary
@Service("GenericBookService")
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return null;
    }

    @Override
    public void addBook(String name, String isbn, Publisher publisher, Set<Author> authors) {

    }
}
