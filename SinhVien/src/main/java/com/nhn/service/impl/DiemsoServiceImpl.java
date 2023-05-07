/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhn.service.impl;

import com.cloudinary.utils.ObjectUtils;
import com.nhn.pojo.Diemso;
import com.nhn.pojo.User;
import com.nhn.repository.DiemsoRepository;
import com.nhn.repository.LophocRepository;
import com.nhn.service.DiemsoService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class DiemsoServiceImpl implements DiemsoService {

    @Autowired
    private DiemsoRepository diemsoRepository;

    @Override
    public List<Diemso> getDiemso(Map<String, String> params) {
        return this.diemsoRepository.getDiemso(params);
    }

    @Override
    public boolean addOrUpdateDiemso(Diemso diemso) {
        if (diemso.getId() != null) {
            // Nếu điểm số đã có trong hệ thống, cập nhật điểm số
            Diemso existingDiemso = this.diemsoRepository.getDiemsoById(diemso.getId());
            if (existingDiemso != null) {
                existingDiemso.setDiemgiuaky(diemso.getDiemgiuaky());
                existingDiemso.setDiemcuoiky(diemso.getDiemcuoiky());
                return this.diemsoRepository.addOrUpdateDiemso(existingDiemso);
            }
        }
        // Nếu điểm số chưa có trong hệ thống, thêm mới điểm số
        return this.diemsoRepository.addOrUpdateDiemso(diemso);
    }

    @Override
    public Diemso getDiemsoById(int id) {
        return this.diemsoRepository.getDiemsoById(id);
    }

}
