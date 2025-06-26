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
        golestan.setCategory("Poet");

        Book boostan = new Book();
        boostan.setName("Boostan");
        boostan.setIsbn("b03r");
        boostan.setCategory("Poet");

        Book shahname = new Book();
        shahname.setName("Shahname");
        shahname.setIsbn("sh34rj");
        shahname.setCategory("Poet");

        Book fizik1 = new Book();
        fizik1.setIsbn("f-12j");
        fizik1.setName("Fizik 1");
        fizik1.setCategory("Science");

        Book riazi1 = new Book();
        riazi1.setName("Riazi 1");
        riazi1.setIsbn("r-b03r");
        riazi1.setCategory("Science");

        Book moadelat = new Book();
        moadelat.setName("Moadelat");
        moadelat.setIsbn("sf-sh34rj");
        moadelat.setCategory("Math");

        Author saadi = new Author();
        saadi.setName("Saadi");
        saadi.setAge(45);

        Author ferdowsi = new Author();
        ferdowsi.setName("Ferdowsi");
        ferdowsi.setAge(65);

        Author iut = new Author();
        iut.setName("Isfahan Uni Tech");
        iut.setAge(89);

        Publisher nashr_cheshme = new Publisher();
        nashr_cheshme.setName("Nashr Cheshmeh");
        nashr_cheshme.setAddress("Tehran, Revenue St");

        List<Book> books = new ArrayList<>();
        books.add(golestan);
        books.add(boostan);
        books.add(shahname);
        books.add(fizik1);
        books.add(riazi1);
        books.add(moadelat);
        Iterable<Book> savedBooks = bookRepository.saveAll(books);

        Set<Book> savedBooksSet = new HashSet<>((Collection) savedBooks);
        nashr_cheshme.setBooks(savedBooksSet);
        publisherRepository.save(nashr_cheshme);

        List<Author> authors = new ArrayList<>();
        authors.add(saadi);
        authors.add(ferdowsi);
        authors.add(iut);
        authorRepository.saveAll(authors);

        golestan.getAuthors().add(saadi);
        boostan.getAuthors().add(saadi);
        shahname.getAuthors().add(ferdowsi);
        riazi1.getAuthors().add(iut);
        fizik1.getAuthors().add(iut);
        moadelat.getAuthors().add(iut);
        bookRepository.saveAll(books);

    }
}
