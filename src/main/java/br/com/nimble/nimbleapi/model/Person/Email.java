package br.com.nimble.nimbleapi.model.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "email_primary")
    private Boolean emailPrimary;

    public Email(String email, Boolean emailPrimary) {
        this.email = email;
        this.emailPrimary = emailPrimary;
    }
}
