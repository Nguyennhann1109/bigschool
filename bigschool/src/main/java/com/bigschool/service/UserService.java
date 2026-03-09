package com.bigschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigschool.entity.User;
import com.bigschool.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }

    public User login(String username,String password){

        User user = userRepository.findByUserName(username);

        if(user != null && user.getPassword().equals(password)){
            return user;
        }

        return null;
    }
}