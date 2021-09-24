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
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "phone_type")
    private String phoneType;

    @Column(name = "phone_primary")
    private Boolean phonePrimary;

    public Phone(String phone, String phoneType, Boolean phonePrimary) {
        this.phone = phone;
        this.phoneType = phoneType;
        this.phonePrimary = phonePrimary;
    }
}
