package com.bigschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bigschool.entity.Following;
import com.bigschool.service.FollowingService;

@RestController
@RequestMapping("/api/follow")
public class FollowingController {

    @Autowired
    private FollowingService followingService;


    @PostMapping
    public Following follow(@RequestParam String follower,
                            @RequestParam String followee){

        return followingService.follow(follower,followee);
    }


    @DeleteMapping
    public void unfollow(@RequestParam String follower,
                         @RequestParam String followee){

        followingService.unfollow(follower,followee);
    }


    @GetMapping("/myfollowing")
    public List<Following> myFollowing(@RequestParam String user){

        return followingService.getFollowing(user);
    }
}