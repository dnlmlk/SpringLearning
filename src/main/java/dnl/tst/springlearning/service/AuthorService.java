package dnl.tst.springlearning.service;

import dnl.tst.springlearning.model.Author;

import java.util.Optional;

public interface AuthorService {
    public Iterable<Author> findAll();
    public Author findById(Long id);
}
