/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhn.repository.impl;

import com.nhn.pojo.Lophoc;
import com.nhn.repository.LophocRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class LophocRepositoryImpl implements LophocRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Lophoc> getLophoc(Map<String, String> params) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Lophoc> q = b.createQuery(Lophoc.class);
        Root root = q.from(Lophoc.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
                Predicate p5 = b.like(root.get("monhocId").get("name").as(String.class), String.format("%%%s%%", kw));
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
        List<Lophoc> lopHoc = query.getResultList();
        return lopHoc;
    }

    @Override
    public Lophoc getLophocById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Lophoc.class, id);
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
