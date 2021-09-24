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

    @Column(name = "address_primary")
    private Boolean addressPrimary;

    public Address(String zipCode,
                   String premisse,
                   String number,
                   String neighbourhood,
                   String information,
                   String location,
                   String state,
                   String country,
                   Boolean addressPrimary) {
        this.zipCode = zipCode;
        this.premisse = premisse;
        this.number = number;
        this.neighbourhood = neighbourhood;
        this.information = information;
        this.location = location;
        this.state = state;
        this.country = country;
        this.addressPrimary = addressPrimary;
    }
}
