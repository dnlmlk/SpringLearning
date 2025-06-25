package dnl.tst.springlearning.repository;

import dnl.tst.springlearning.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
