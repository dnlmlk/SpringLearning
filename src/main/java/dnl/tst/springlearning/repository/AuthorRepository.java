package dnl.tst.springlearning.repository;

import dnl.tst.springlearning.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
