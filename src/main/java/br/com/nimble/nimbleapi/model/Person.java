package br.com.nimble.nimbleapi.model;

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
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sexo")
    public String sexo;

    @Column(name = "cpf")
    public String cpf;

    @Column(name = "rg")
    public String rg;

    @Column(name = "cnpj")
    public String cnpj;

    @Column(name = "ie")
    public String ie;

    @Column(name = "birth_date")
    public Date birthDate;

    @Column(name = "foundation_date")
    public Date foundationDate;
}
