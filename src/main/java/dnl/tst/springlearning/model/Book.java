package dnl.tst.springlearning.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString
@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String isbn;
    private String category;
    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
//    @JsonManagedReference
    @JsonIgnore
    private Set<Author> authors = new HashSet<>();
    @ManyToOne
//    @JsonManagedReference
    @JsonIgnore
    private Publisher publisher;
}
