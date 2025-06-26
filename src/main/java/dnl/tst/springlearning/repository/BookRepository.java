package dnl.tst.springlearning.repository;

import dnl.tst.springlearning.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> findBookByCategory(String category);
    Book findBookByIdAndCategory(Long id, String category);
}
