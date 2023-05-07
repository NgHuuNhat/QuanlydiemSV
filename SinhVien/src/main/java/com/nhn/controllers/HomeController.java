/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhn.controllers;

import com.nhn.pojo.Diemso;
import com.nhn.pojo.Lophoc;
import com.nhn.pojo.Monhoc;
import com.nhn.pojo.Role;
import com.nhn.pojo.User;
import com.nhn.service.DiemsoService;
import com.nhn.service.LophocService;
import com.nhn.service.MonhocService;
import com.nhn.service.RoleService;
import com.nhn.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private LophocService lophocService;
    @Autowired
    private MonhocService monhocService;
    @Autowired
    private DiemsoService diemsoService;

    //role
    @ModelAttribute
    public void commonAttributes(Model model) {
        List<Role> role = this.roleService.getRoles();
        model.addAttribute("role", role);
    }

    //user
    @RequestMapping(path = {"/monhoc/users", "users"})
    public String index(Model model, @RequestParam Map<String, String> params) {
        List<User> users = this.userService.getUsers(params);
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping(path = {"/users/{userId}", "/userdiemso"})
    public String userDetail(Model model, @PathVariable(value = "userId") int id) {
        model.addAttribute("u", this.userService.getUserById(id));
        return "user-detail";
    }

    //lophoc
    @RequestMapping(path = {"/", "/lophoc"})
    public String indexLopHoc(Model model, @RequestParam Map<String, String> params) {
        List<Lophoc> lop = this.lophocService.getLophoc(params);
        model.addAttribute("lophoc", lop);
        return "indexLopHoc";
    }

    //monhoc
    @RequestMapping(path = {"/lophoc/monhoc", "monhoc"})
    public String indexMonHoc(Model model, @RequestParam Map<String, String> params) {
        List<Monhoc> mon = this.monhocService.getMonhoc(params);
        model.addAttribute("monhoc", mon);
        return "indexMonHoc";
    }

    //diemso
    @RequestMapping(path = {"/userdiemso/diem", "diemso"})
    public String indexDiemSo(Model model, @RequestParam Map<String, String> params) {
        List<Diemso> diem = this.diemsoService.getDiemso(params);
        model.addAttribute("diemso", diem);
        return "indexDiemSo";
    }

    @RequestMapping(path = {"/diemso/{diemsoId}"})
    public String indexDiemSo(Model model, @PathVariable(value = "diemsoId") int id) {
        // Khai báo và khởi tạo tham số params
        Map<String, String> params = new HashMap<String, String>();

        // Lấy danh sách user
        List<User> users = this.userService.getUsers(params);
        model.addAttribute("users", users);

        // Lấy danh sách môn học
        List<Monhoc> monhocs = this.monhocService.getMonhoc(params);
        model.addAttribute("monhocs", monhocs);

        // Lấy thông tin điểm theo ID và đưa vào Model để sử dụng trong form
        Diemso diemso = this.diemsoService.getDiemsoById(id);
        model.addAttribute("diemsochitiet", diemso);

//        model.addAttribute("diemso1", this.diemsoService.getDiemsoById(id));
        return "indexDiemSodiemso1";
    }

}
