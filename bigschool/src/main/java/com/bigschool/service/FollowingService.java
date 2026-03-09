package com.bigschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigschool.entity.Following;
import com.bigschool.repository.FollowingRepository;

@Service
public class FollowingService {

    @Autowired
    private FollowingRepository followingRepository;

    public Following follow(String follower,String followee){

        Following f = new Following();
        f.setFollower(follower);
        f.setFollowee(followee);

        return followingRepository.save(f);
    }

    public void unfollow(String follower,String followee){

        Following f = followingRepository
                .findByFollowerAndFollowee(follower,followee);

        if(f != null){
            followingRepository.delete(f);
        }
    }

    public List<Following> getFollowing(String user){

        return followingRepository.findByFollower(user);
    }
}