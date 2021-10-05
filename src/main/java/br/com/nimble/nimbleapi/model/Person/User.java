package br.com.nimble.nimbleapi.model.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "occupation")
    private String occupation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person")
    public Person person;

    public User() {

    }
}
