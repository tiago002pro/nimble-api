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
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "holder")
    private String holder;
    @Column(name = "holder_document")
    private String holderDocument;
    @Column(name = "limit")
    private Double limit;
    @Column(name = "modality")
    private String modality;
    @Column(name = "bank")
    private String bank;
    @Column(name = "type")
    private String type;
    @Column(name = "agency")
    private String agency;
    @Column(name = "agency_dv")
    private String agencyDv;
    @Column(name = "account")
    private String account;
    @Column(name = "account_dv")
    private String accountDv;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "active")
    private Boolean active;
}