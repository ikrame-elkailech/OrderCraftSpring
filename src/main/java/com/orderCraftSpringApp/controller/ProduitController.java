package com.orderCraftSpringApp.controller;

import com.orderCraftSpringApp.model.Produit;
import com.orderCraftSpringApp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/produits")
    public  String listProduit(Model model){
        List<Produit> produits = produitService.getAllProduit();
        produits.forEach(System.out::println);
        model.addAttribute("produits",produits);
        return "Produit/produits";
    }

    @GetMapping("/addProduit")
    public  String addProduit(){
        return "Produit/addProduit";
    }

    @PostMapping("/saveProduit")
    public  String saveProduit(Produit produit){
        produitService.saveProduit(produit);
        return "redirect:/produits";
    }

    @GetMapping("/editProduit/{id}")
    public String editProduit(@PathVariable Long id, Model model) {
        Produit produit = produitService.getProduit(id).orElseThrow(() -> new RuntimeException("Produit not found")); // Adjust the exception handling
        model.addAttribute("produit", produit);
        return "Produit/editProduit";
    }

    @PostMapping("/updateProduit")
    public String updateProduit(@ModelAttribute Produit produit) {
        produitService.saveProduit(produit);
        return "redirect:/produits";
    }

    @GetMapping("/deleteProduit/{id}")
    public String deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return "redirect:/produits";
    }
}
