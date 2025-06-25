package dnl.tst.springlearning.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
