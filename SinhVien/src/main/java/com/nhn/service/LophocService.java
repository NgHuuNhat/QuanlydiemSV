/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhn.service;

import com.nhn.pojo.Lophoc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface LophocService {
    List<Lophoc> getLophoc(Map<String, String> params);
    Lophoc getLophocById(int id);
//    boolean addOrUpdateLophoc(Lophoc lophoc);
//    boolean deleteLophoc(int id);
}
