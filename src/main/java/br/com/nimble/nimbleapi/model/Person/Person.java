package br.com.nimble.nimbleapi.model.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dateofbirthorfondation")
    public LocalDate dateofbirthorfondation;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    public List<Address> addresses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    public List<Phone> phones = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    public List<Email> emails = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    public List<Document> documents = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    public List<Rule> ruleList = new ArrayList<>();

    public Person (String name, List<Address> addresses, List<Phone> phones, List<Email> emails, List<Document> documents, List<Rule> ruleList) {
        this.name = name;
        this.addresses = addresses;
        this.phones = phones;
        this.emails = emails;
        this.documents = documents;
        this.ruleList = ruleList;
    }

    public Person () {
    }
}
