package br.com.nimble.nimbleapi.model.Finance;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "subcategory")
@Data
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
