package br.com.nimble.nimbleapi.model.Finance;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private List<SubCategory> subCategoryList;
}