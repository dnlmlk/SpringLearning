package dnl.tst.springlearning.service;

import dnl.tst.springlearning.model.Author;
import dnl.tst.springlearning.model.Book;
import dnl.tst.springlearning.model.Publisher;
import dnl.tst.springlearning.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("PoetBookService")
public class BookServicePoetImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServicePoetImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findBookByCategory("Poet");
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findBookByIdAndCategory(id, "Poet");
    }

    @Override
    public void addBook(String name, String isbn, Publisher publisher, Set<Author> authors) {
        Book book = new Book();
        book.setName(name);
        book.setIsbn(isbn);
        book.setCategory("Poet");

        book.setPublisher(publisher);
        book.setAuthors(authors);
        bookRepository.save(book);
    }
}
