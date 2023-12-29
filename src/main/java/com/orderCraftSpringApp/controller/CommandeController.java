package com.orderCraftSpringApp.controller;

import com.orderCraftSpringApp.model.Client;
import com.orderCraftSpringApp.model.Commande;
import com.orderCraftSpringApp.model.Produit;
import com.orderCraftSpringApp.service.ClientService;
import com.orderCraftSpringApp.service.CommandeService;
import com.orderCraftSpringApp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CommandeController {


    private CommandeService commandeService;
    private ClientService clientService;
    private ProduitService produitService;
    @Autowired
    public CommandeController(CommandeService commandeService,ClientService clientService,ProduitService produitService){
        this.clientService=clientService;
        this.commandeService=commandeService;
        this.produitService=produitService;

    }
    @GetMapping("/commandes")
    public String listCommade(Model model){
        List<Commande> commandes = commandeService.getAllCommandes();
        commandes.forEach(System.out::println);
        model.addAttribute("commandes",commandes);
        return "Commande/commandes";
    }

    @GetMapping("/addCommande")
    public  String addCommande(Model model){
        List<Client> clientList = clientService.getAllClient();
        model.addAttribute("clients", clientList);
        List<Produit> produitList = produitService.getAllProduit();
        model.addAttribute("produits", produitList);
        return "Commande/addCommande";
    }

    @PostMapping("/saveCommande")
    public  String saveCommande(Commande commande){
        commandeService.saveCommande(commande);
        return "redirect:/commandes";
    }

}
