package com.orderCraftSpringApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero_commande;
    private Date date_commande;
    private int id_client;
    //private int id_user;

    public Commande() {
    }

    public Commande(Long id, String numero_commande, Date date_commande, int id_client) {
        this.id = id;
        this.numero_commande = numero_commande;
        this.date_commande = date_commande;
        this.id_client = id_client;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_commande() {
        return numero_commande;
    }

    public void setNumero_commande(String numero_commande) {
        this.numero_commande = numero_commande;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "Commande{" +

                ", numero_commande='" + numero_commande + '\'' +
                ", date_commande=" + date_commande +
                ", id_client=" + id_client +
                '}';
    }
}
