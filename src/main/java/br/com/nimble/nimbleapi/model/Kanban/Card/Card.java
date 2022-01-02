package br.com.nimble.nimbleapi.model.Kanban.Card;

import br.com.nimble.nimbleapi.model.Kanban.ListCard;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "creation_date")
    private Date executionDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "list_card_id")
    private ListCard listCard;
}