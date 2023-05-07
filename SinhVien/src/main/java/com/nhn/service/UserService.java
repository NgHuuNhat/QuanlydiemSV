/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhn.service;

import com.nhn.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Admin
 */
public interface UserService extends UserDetailsService {
    List<User> getUsers(Map<String, String> params);
    User getUserById(int id);
    boolean addOrUpdateUser(User u);
    boolean deleteUser(int id);
    
    public User getUserByUsername(String username);
}
