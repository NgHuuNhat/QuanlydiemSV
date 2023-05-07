/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhn.service;

import com.nhn.pojo.Diemso;
import com.nhn.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface DiemsoService {
    List<Diemso> getDiemso(Map<String, String> params);
    boolean addOrUpdateDiemso(Diemso diemso);
    Diemso getDiemsoById(int id);
}
