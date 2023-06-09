package ra.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
@OneToMany(mappedBy = "catalog",targetEntity = Car.class)
private Set<Car> cars;
    public Catalog() {
    }

    public Catalog(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
