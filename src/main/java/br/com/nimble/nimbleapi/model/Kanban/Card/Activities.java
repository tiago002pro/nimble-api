package br.com.nimble.nimbleapi.model.Kanban.Card;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activities")
@Getter
@Setter
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "activity")
    private String activity;

    @Column(name = "execution_date")
    private Date executionDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private Card card;
}
