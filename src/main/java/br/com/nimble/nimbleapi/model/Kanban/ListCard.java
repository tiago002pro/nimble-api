package br.com.nimble.nimbleapi.model.Kanban;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "list_card")
@Getter
@Setter
public class ListCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "index_list")
    private Long indexList;

//    @OneToMany
//    @JoinColumn(name = "list_card_id")
//    private List<Card> cardList;
}