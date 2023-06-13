package com.example.asn2.controllers;

//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.asn2.models.Users;
import com.example.asn2.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UsersController {  
    
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users/view")
    public String getAllUsers(Model model){
        System.out.println("Getting all users");
        // get all users from database
        List<Users> users = userRepo.findAll();
        // end of database call
        model.addAttribute("us", users);
        
        return "users/showAll";
    }


    @PostMapping("/users/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response){
        System.out.println("ADD user");
        String newName = newuser.get("name");
        int newWeight = Integer.parseInt(newuser.get("weight"));
        int newHeight = Integer.parseInt(newuser.get("height"));
        float newGPA = Float.parseFloat(newuser.get("GPA"));
        String newHairColor = newuser.get("hairColor");
        
        userRepo.save(new Users(newName,newWeight,newHeight,newHairColor, newGPA));
        response.setStatus(201);
        return "users/addedUser";
    }
    
    @DeleteMapping("/users/delete/{uid}")
    public String deleteById(@PathVariable("uid") int uid) {
        //System.out.println(uid);
        userRepo.deleteById(uid); //delete user by id
        
        return "users/showAll";
    }

    @GetMapping("/users/view/{uid}")
    public String editById(Model model, HttpServletResponse response, @PathVariable String uid){
        //System.out.println("Getting all users");

        // get all users from database
        int id = Integer.parseInt(uid);
        Users users = userRepo.findById(id).get();
        // end of database call
        model.addAttribute("us", users);
        
        //response.setStatus(201);
        return "users/editUser";
    }
    
    @PostMapping("users/edit/{uid}")
    public String editData(@RequestParam Map<String, String> newuser, HttpServletResponse response, @PathVariable String uid){
        String newName = newuser.get("name");
        int newWeight = Integer.parseInt(newuser.get("weight"));
        int newHeight = Integer.parseInt(newuser.get("height"));
        float newGPA = Float.parseFloat(newuser.get("GPA"));
        String newHairColor = newuser.get("hairColor");

        int id = Integer.parseInt(uid);

        Users users = userRepo.findById(id).get(); //get users by order of id

        //using setters to set new data to the old data upon editing
        users.setName(newName);
        users.setWeight(newWeight);
        users.setheight(newHeight);
        users.setGPA(newGPA);
        users.setHairColor(newHairColor);
        userRepo.save(users);
        //response.setStatus(201);

        return "redirect:/users/view"; //redirect back to the table

    }

        
        
    

}