package dnl.tst.springlearning.model;

import jakarta.persistence.*;
import org.apache.tomcat.util.http.parser.Authorization;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String isbn;
    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();
}
