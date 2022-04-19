package br.com.nimble.nimbleapi.model.Finance;

import br.com.nimble.nimbleapi.model.Person.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Title")
@Getter
@Setter
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "doc_number")
    private String docNumber;
    @Column(name = "emission_date")
    private Date emissionDate;
    @Column(name = "value")
    private Double value;
    @Column(name = "parcel")
    private Boolean parcel;
    @Column(name = "parcel_number")
    private Integer parcelNumber;
    @Column(name = "duo_date")
    private Date duoDate;
    @Column(name = "historic")
    private String historic;
    @Column(name = "type")
    private String type;
    @Column(name = "status")
    private String status;
    @Column(name = "pay_day")
    private Date payDay;
    @Column(name = "paid")
    private Boolean paid;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
}