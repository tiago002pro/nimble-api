package br.com.nimble.nimbleapi.model.Finance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "account")
    private String account;
    @Column(name = "account_dv")
    private String accountDv;
    @Column(name = "agency")
    private String agency;
    @Column(name = "agency_dv")
    private String agencyDv;
    @Column(name = "banck_id")
    private String banckId;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "holder")
    private String holder;
    @Column(name = "holder_document")
    private String holderDocument;
}
