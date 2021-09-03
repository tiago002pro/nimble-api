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
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "premisse")
    private String premisse;

    @Column(name = "premisse_type")
    private String premisseType;

    @Column(name = "number")
    private String number;

    @Column(name = "neighbourhood")
    private String neighbourhood;

    @Column(name = "information")
    private String information;

    @Column(name = "location")
    private String location;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;
}
