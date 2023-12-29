package com.orderCraftSpringApp.controller;


import com.orderCraftSpringApp.model.Client;
import com.orderCraftSpringApp.model.User;
import com.orderCraftSpringApp.repository.ClientRepository;
import com.orderCraftSpringApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("Client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    private ClientRepository clientRepository;

    @GetMapping("/signup")
    public String showSignUpForm(Client client) {
        return "addClient";
    }
    @GetMapping("/clients")
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.getAllClient());
        return "clients";
    }



    @PostMapping("/addClient")
    public String addClient(Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addClient";
        }
        clientService.saveClient(client);
        return "redirect:clients";

    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Client client = clientService.getClient(id);
               //.orElseThrow(()-> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        return "editClient";
    }

    @PostMapping("/updateClient/{id}")
    public String updateClient(@PathVariable("id") long id, @Valid Client client, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            client.setId(id);
            return "editClient";
        }

        clientRepository.save(client);
        model.addAttribute("clients", clientRepository.findAll());
        return "clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") long id, Model model) {
        System.out.println(id);
        clientService.deleteClient(id);
        model.addAttribute("clients", clientRepository.findAll());
        return "clients";
    }


}
