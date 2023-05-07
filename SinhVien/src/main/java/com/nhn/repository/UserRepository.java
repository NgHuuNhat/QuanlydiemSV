/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhn.repository;

import java.util.List;
import com.nhn.pojo.User;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface UserRepository {
    List<User> getUsers(Map<String, String> params);
    User getUserById(int id);
    boolean addOrUpdateUser(User u);
    boolean deleteUser(int id);
    
    User getUserByUsername(String username);
}
