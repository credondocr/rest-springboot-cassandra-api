package com.redondocr.controllers;

import com.redondocr.domain.User;
import com.redondocr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity(service.getUsers(), HttpStatus.OK);
    }


    @RequestMapping( method = RequestMethod.POST, produces = "application/json", consumes = "application/json" )
    public ResponseEntity<User> addUser(@RequestBody User user){
        User userCreated = service.createUser(user);
        return new ResponseEntity(userCreated, HttpStatus.CREATED);
    }

    @RequestMapping( path = "/{id}", method = RequestMethod.GET, produces = "application/json" )
    public ResponseEntity<User> getUserById(@PathVariable String id){
        if(!service.exitsUser(id)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        User user = service.findUserById(id);
        return new ResponseEntity(user,HttpStatus.ACCEPTED);
    }

    @RequestMapping(  method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<User> editUser(@RequestBody User user){
        if(user.getUserid() == null || !service.exitsUser(user.getUserid())){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        User userEdited = service.editUser(user);
        return new ResponseEntity(userEdited, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable String id){
        if(!service.exitsUser(id)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        User user = service.findUserById(id);
        service.deleteUser(id);
        return new ResponseEntity(user, HttpStatus.ACCEPTED);

    }

}
