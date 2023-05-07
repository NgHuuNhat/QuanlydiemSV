/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhn.service.impl;

import com.nhn.pojo.Lophoc;
import com.nhn.repository.LophocRepository;
import com.nhn.service.LophocService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class LophocServiceImpl implements LophocService {

    @Autowired
    private LophocRepository lophocRepository;

    @Override
    public List<Lophoc> getLophoc(Map<String, String> params) {
        return this.lophocRepository.getLophoc(params);
    }

    @Override
    public Lophoc getLophocById(int id) {
        return this.lophocRepository.getLophocById(id);
    }

//    @Override
//    public boolean addOrUpdateLophoc(Lophoc lophoc) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public boolean deleteLophoc(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

}
