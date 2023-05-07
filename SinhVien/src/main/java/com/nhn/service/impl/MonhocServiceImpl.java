/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhn.service.impl;

import com.nhn.pojo.Monhoc;
import com.nhn.repository.MonhocRepository;
import com.nhn.service.MonhocService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class MonhocServiceImpl implements MonhocService {

    @Autowired
    private MonhocRepository monhocRepository;

    @Override
    public List<Monhoc> getMonhoc(Map<String, String> params) {
        return this.monhocRepository.getMonhoc(params);
    }

    @Override
    public Monhoc getMonhocById(int id) {
        return this.monhocRepository.getMonhocById(id);
    }
}
