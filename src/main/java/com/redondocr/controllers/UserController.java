package com.redondocr.controllers;

import com.redondocr.domain.User;
import com.redondocr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by credondo on 6/16/16.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping( method = RequestMethod.GET, produces = "application/json" )
    public List<User> getUsers(){
        return service.getUsers();
    }


    @RequestMapping( method = RequestMethod.POST, produces = "application/json", consumes = "application/json" )
    public User addUser(@RequestBody User user){
        return service.createUser(user);
    }

    @RequestMapping( path = "/{id}", method = RequestMethod.GET, produces = "application/json" )
    public User getUserById(@PathVariable String id){
        return service.findUserById(id);
    }

    @RequestMapping(  method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public User editUser(@RequestBody User user){
        return service.editUser(user);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable String id){
        User user = getUserById(id);
        service.deleteUser(id);
        return user;

    }

}
