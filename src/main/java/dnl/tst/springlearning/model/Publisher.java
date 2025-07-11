package dnl.tst.springlearning.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString
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
