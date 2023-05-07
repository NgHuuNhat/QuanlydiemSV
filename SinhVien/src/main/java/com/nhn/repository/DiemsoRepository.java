/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhn.repository;

import com.nhn.pojo.Diemso;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface DiemsoRepository {
    List<Diemso> getDiemso(Map<String, String> params);
    boolean addOrUpdateDiemso(Diemso diemso);
    Diemso getDiemsoById(int id);
}
