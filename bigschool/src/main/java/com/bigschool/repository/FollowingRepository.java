package com.bigschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bigschool.entity.Following;

public interface FollowingRepository extends JpaRepository<Following,Integer> {

    List<Following> findByFollower(String follower);

    Following findByFollowerAndFollowee(String follower,String followee);

}