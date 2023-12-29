package com.orderCraftSpringApp.service;

import com.orderCraftSpringApp.model.Client;
import com.orderCraftSpringApp.model.Commande;
import com.orderCraftSpringApp.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public  List<Commande> getAllCommandes(){
        return commandeRepository.findAll();
    }
    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }
    public Commande saveCommande(Commande commande){
        return commandeRepository.save(commande);
    };
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }

}
