package com.bigschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bigschool.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

}