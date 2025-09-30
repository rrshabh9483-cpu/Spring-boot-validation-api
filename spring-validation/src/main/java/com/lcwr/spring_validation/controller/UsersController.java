package com.lcwr.spring_validation.controller;

import com.lcwr.spring_validation.entity.User;
import com.lcwr.spring_validation.exception.InvalidAgeException;
import com.lcwr.spring_validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/Users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        if (user.getAge()<10){
            throw new InvalidAgeException("Age must be greater than 10 years");
        }
        else {

            User savedUser = userService.saveUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }

    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        for(User u: allUsers){

        }
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
          }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getParticularUser(@PathVariable int id) {
        User particularUser = userService.getSingleUser(id);
        return new ResponseEntity<>(particularUser,HttpStatus.OK);
    }

    @GetMapping("users/calculate_percentage")
    public ResponseEntity<Integer> getPercentage() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter your part");
        int a = scan.nextInt();
        System.out.println("enter total value");
        int b = scan.nextInt();
        System.out.println("ther percentage is: ");
        int c = (a/b)*100;
        System.out.println(c);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
}
