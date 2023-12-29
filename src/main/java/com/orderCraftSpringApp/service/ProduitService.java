package com.orderCraftSpringApp.service;

import com.orderCraftSpringApp.model.Client;
import com.orderCraftSpringApp.model.Produit;
import com.orderCraftSpringApp.repository.ClientRepository;
import com.orderCraftSpringApp.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Transactional
    public List<Produit> getAllProduit(){
        return produitRepository.findAll();
    }


    @Transactional
    public Produit saveProduit(Produit produit)
    { return  produitRepository.save(produit);}

    @Transactional
    public Produit getProduit(long id) throws NullPointerException {
        return produitRepository.findById(id).orElseThrow(
                () -> new NullPointerException("User with ID = ${id} is not found"));
    }


    @Transactional
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }


}
