package br.com.nimble.nimbleapi.model.Finance;

import br.com.nimble.nimbleapi.model.Person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "title")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "movement_date")
    private Date movementDate;

    @Column(name = "historic")
    private String historic;

    @Column(name = "value")
    private Double value;

    @Column(name = "final_value")
    private Double finalValue;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Subcategory subcategory;


}
