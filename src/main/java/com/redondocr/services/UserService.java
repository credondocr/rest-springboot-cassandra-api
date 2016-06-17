package com.redondocr.services;

import com.redondocr.domain.User;
import com.redondocr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.cassandra.repository.support.BasicMapId.id;


/**
 * Created by credondo on 6/17/16.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(String userId){
        MapId id = id("userid", userId);
        return userRepository.findOne(id);
    }

    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }

    public User editUser(User user){
        return userRepository. save(user);
    }

    public void deleteUser(String userId){
        MapId id = id("userid", userId);
        userRepository.delete(id);
    }

    public boolean exitsUser(String userId){
        MapId id = id("userid", userId);
        return userRepository.exists(id);
    }

}
