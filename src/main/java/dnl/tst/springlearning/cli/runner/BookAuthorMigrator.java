package dnl.tst.springlearning.cli.runner;

import dnl.tst.springlearning.model.Author;
import dnl.tst.springlearning.model.Book;
import dnl.tst.springlearning.model.Publisher;
import dnl.tst.springlearning.repository.AuthorRepository;
import dnl.tst.springlearning.repository.BookRepository;
import dnl.tst.springlearning.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookAuthorMigrator implements CommandLineRunner {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public BookAuthorMigrator(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book golestan = new Book();
        golestan.setIsbn("g-12j");
        golestan.setName("Golestan");

        Book boostan = new Book();
        boostan.setName("Boostan");
        boostan.setIsbn("b03r");

        Book shahname = new Book();
        shahname.setName("Shahname");
        shahname.setIsbn("sh34rj");

        Author saadi = new Author();
        saadi.setName("Saadi");
        saadi.setAge(45);

        Author ferdowsi = new Author();
        ferdowsi.setName("Ferdowsi");
        ferdowsi.setAge(65);

        Publisher nashr_cheshme = new Publisher();
        nashr_cheshme.setName("Nashr Cheshmeh");
        nashr_cheshme.setAddress("Tehran, Revenue St");

        List<Book> books = new ArrayList<>();
        books.add(golestan);
        books.add(boostan);
        books.add(shahname);
        Iterable<Book> savedBooks = bookRepository.saveAll(books);

        Set<Book> savedBooksSet = new HashSet<>((Collection) savedBooks);
        nashr_cheshme.setBooks(savedBooksSet);
        publisherRepository.save(nashr_cheshme);

        List<Author> authors = new ArrayList<>();
        authors.add(saadi);
        authors.add(ferdowsi);
        authorRepository.saveAll(authors);

        golestan.getAuthors().add(saadi);
        boostan.getAuthors().add(saadi);
        shahname.getAuthors().add(ferdowsi);
        bookRepository.saveAll(books);

    }
}
