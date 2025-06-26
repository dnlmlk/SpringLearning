package dnl.tst.springlearning.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Publisher {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "publisher")
    @JsonBackReference
    private Set<Book> books = new HashSet<>();
}
