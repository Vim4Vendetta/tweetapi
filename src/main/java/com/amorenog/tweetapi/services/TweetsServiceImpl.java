package com.amorenog.tweetapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.amorenog.tweetapi.models.Tweet;
import com.amorenog.tweetapi.models.User;
import com.amorenog.tweetapi.repositories.TweetsRepository;
import com.amorenog.tweetapi.repositories.UsersRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twitter4j.TwitterStream;

@Service
public class TweetsServiceImpl implements TweetsService {

    @Autowired
    TwitterStream twitterStream;

    @Autowired
    TweetsRepository tweetsRepo;

    @Autowired
    UsersRepository usersRepo;

    private static Logger logger = LoggerFactory.getLogger(TweetsServiceImpl.class);

    @Override
    public List<Tweet> getAllTweets() {
        return new ArrayList<Tweet>();
    }

    @Override
    public Tweet save(Tweet tweet) {
        tweet.setUser(usersRepo.findById(tweet.getUser().getId())
            .orElse(usersRepo.save(tweet.getUser())));
        return tweetsRepo.save(tweet);
    }

}
