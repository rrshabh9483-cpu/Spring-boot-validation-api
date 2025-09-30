package com.lcwr.spring_validation.service;

import com.lcwr.spring_validation.entity.User;
import com.lcwr.spring_validation.repository.UserRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepositroy userRepositroy;

    public User saveUser(User user) {
        return userRepositroy.save(user);
    }

    public List<User> getAllUsers() {
        return userRepositroy.findAll();
    }

    public User updateUsers(User user) {
        User updatedUser = null;
        List<User> allUsers = userRepositroy.findAll();
        for(User u: allUsers){
            if(u.getUserId() == user.getUserId()) {
                updatedUser =userRepositroy.save(u);
                break;
            }

        }
        return  updatedUser;
    }

    public User getSingleUser(int id) {
//        User usu = null;
//        List<User> allUsers = userRepositroy.findAll();
//        for(User u : allUsers) {
//            if(u.getUserId() == id) {
//                usu = u;
//                break;
//            }
//        }
//        return usu;
        return userRepositroy.findById(id).get();
    }
}
