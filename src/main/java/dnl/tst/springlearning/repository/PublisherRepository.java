package dnl.tst.springlearning.repository;

import dnl.tst.springlearning.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
