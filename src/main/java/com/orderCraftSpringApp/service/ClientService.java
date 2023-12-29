package com.orderCraftSpringApp.service;

import com.orderCraftSpringApp.model.Client;
import com.orderCraftSpringApp.model.User;
import com.orderCraftSpringApp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }


    @Transactional
    public Client saveClient(Client client)
    { return  clientRepository.save(client);}

    @Transactional
    public Client getClient(long id) throws NullPointerException {
        return clientRepository.findById(id).orElseThrow(
                () -> new NullPointerException("User with ID = ${id} is not found"));
    }


    @Transactional
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}
