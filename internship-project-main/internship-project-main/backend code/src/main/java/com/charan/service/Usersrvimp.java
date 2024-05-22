package com.charan.service;

import com.charan.entity.Admin;
import com.charan.model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.charan.repo.UserRepo;
import com.charan.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Usersrvimp implements Usersrv {
    @Autowired
    private UserRepo userRepo;
    public ResponseEntity<String> registration(User user)
    {

        Optional<Object> user1=Optional.of( userRepo.save(user));
        if(user1.isPresent())
            return new ResponseEntity<>("successfully registered", HttpStatus.OK);
        else
            return new ResponseEntity<>("failed to registered", HttpStatus.BAD_REQUEST);
    }
	
    public ResponseEntity<String> login(String userId,String password)
    {
        if(userRepo.findByUidAndPswrd(userId,password).isPresent())
            return new ResponseEntity<>("Success", HttpStatus.OK);
        else
            return new ResponseEntity<>("loginfailed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> getAllUsers()
    {
         List<User> userList=userRepo.findAll();
        ObjectMapper Obj = new ObjectMapper();
     List<UserModel> userModels=   userList.stream().map(user->
        { UserModel userModel=new UserModel();
            String jsonStr="";
            try {
                jsonStr = Obj.writeValueAsString(user);
                userModel= Obj.readValue(jsonStr, UserModel.class);

            }
            catch (Exception e) {
                System.out.println(e);
            }
            return userModel;
        }).collect(Collectors.toList());

      return new ResponseEntity<>(userModels,HttpStatus.OK);
    }
}
