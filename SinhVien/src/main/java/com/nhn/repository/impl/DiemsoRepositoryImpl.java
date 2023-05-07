/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhn.repository.impl;

import com.nhn.pojo.Diemso;
import com.nhn.pojo.User;
import com.nhn.repository.DiemsoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class DiemsoRepositoryImpl implements DiemsoRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Diemso> getDiemso(Map<String, String> params) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Diemso> q = b.createQuery(Diemso.class);
        Root root = q.from(Diemso.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("diemgiuaky").as(String.class), String.format("%%%s%%", kw));
                Predicate p5 = b.like(root.get("diemcuoiky").as(String.class), String.format("%%%s%%", kw));
                Predicate p6 = b.or(p1, p5);
                q.where(p6);
                predicates.add(p6);
            }

            String monhocId = params.get("monhocId");
            if (monhocId != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("monhocId"), Integer.parseInt(monhocId));
                predicates.add(p);
            }
            q.where(predicates.toArray(new Predicate[]{}));
        }

        q.orderBy(b.desc(root.get("id")));
        Query query = s.createQuery(q);
        List<Diemso> Diemso = query.getResultList();
        return Diemso;
    }

    @Override
    public boolean addOrUpdateDiemso(Diemso diemso) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (diemso.getId() > 0) {
                s.update(diemso);
            } else {
                s.save(diemso);
            }
            return true;
        } catch (HibernateException ex) {
            return false;
        }
    }

    @Override
    public Diemso getDiemsoById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Diemso.class, id);
    }

}
