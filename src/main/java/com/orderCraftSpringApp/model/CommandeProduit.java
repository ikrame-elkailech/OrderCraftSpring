package com.orderCraftSpringApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;


import javax.persistence.*;


@Entity
public class CommandeProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantite;
    private Double Prix;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    public CommandeProduit() {
    }

    public CommandeProduit(Long id, int quantite, Double prix, Commande commande, Produit produit) {
        this.id = id;
        this.quantite = quantite;
        Prix = prix;
        this.commande = commande;
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Double getPrix() {
        return Prix;
    }

    public void setPrix(Double prix) {
        Prix = prix;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "CommandeProduit{" +
                "quantite=" + quantite +
                ", Prix=" + Prix +
                ", commande=" + commande +
                ", produit=" + produit +
                '}';
    }
}
