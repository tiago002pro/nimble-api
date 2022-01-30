package br.com.nimble.nimbleapi.model.Kanban;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "index_card")
    private Long indexCard;

    @Column(name = "creation_date")
    @CreationTimestamp
    private Date executionDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private List<Activity> activityList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "list_card_id")
    private ListCard listCard;
}