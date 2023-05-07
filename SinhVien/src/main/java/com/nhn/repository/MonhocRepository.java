/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhn.repository;

import com.nhn.pojo.Monhoc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface MonhocRepository {
    List<Monhoc> getMonhoc(Map<String, String> params);
    Monhoc getMonhocById(int id);
}
