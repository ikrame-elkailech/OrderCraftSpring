package com.orderCraftSpringApp.service;

import com.orderCraftSpringApp.model.User;
import com.orderCraftSpringApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User saveUser(User user)
    { return  userRepository.save(user);}

    @Transactional
    public User getUsr(long id) throws NullPointerException {
        return userRepository.findById(id).orElseThrow(
                () -> new NullPointerException("User with ID = ${id} is not found"));
    }


    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}