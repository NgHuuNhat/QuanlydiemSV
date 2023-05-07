/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhn.controllers;

import com.nhn.pojo.User;
import com.nhn.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    
    @ModelAttribute
    public void commonAttributes(Model model){
        model.addAttribute("users", this.userService.getUsers(null));
    }

    @RequestMapping("/users")
    public String addUser(Model model, @ModelAttribute(value = "u") @Valid User u, BindingResult rs) {
        if(rs.hasErrors()){
            return "users";
        }
        
        if (this.userService.addOrUpdateUser(u) == true) {
            return "redirect:/admin/users";
        } else {
            model.addAttribute("errMsg", "Something Wrong!!!");
        }

        return "users";
    }

    @GetMapping("/users")
    public String user(Model model) {
        model.addAttribute("u", new User());
        model.addAttribute("users", this.userService.getUsers(null));
        return "users";
    }
    
    @GetMapping("/users/{userId}")
    public String updateUser(Model model, @PathVariable(value="userId") int id){
        model.addAttribute("u", this.userService.getUserById(id));
        return "users";
    }
}
