/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhn.repository.impl;

import com.nhn.pojo.Monhoc;
import com.nhn.pojo.Monhoc;
import com.nhn.repository.MonhocRepository;
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
public class MonhocRepositoryImpl implements MonhocRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Monhoc> getMonhoc(Map<String, String> params) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Monhoc> q = b.createQuery(Monhoc.class);
        Root root = q.from(Monhoc.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
                Predicate p4 = b.like(root.get("diemsoId").get("diemgiuaky").as(String.class), String.format("%%%s%%", kw));
                Predicate p5 = b.like(root.get("diemsoId").get("deimcuoiky").as(String.class), String.format("%%%s%%", kw));

                Predicate p6 = b.or(p1, p4, p5);
                q.where(p6);
                predicates.add(p6);
            }

            String diemsoId = params.get("diemsoId");
            if (diemsoId != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("diemsoId"), Integer.parseInt(diemsoId));
                predicates.add(p);
            }
            q.where(predicates.toArray(new Predicate[]{}));
        }

        q.orderBy(b.desc(root.get("id")));
        Query query = s.createQuery(q);
        List<Monhoc> Monhoc = query.getResultList();
        return Monhoc;
    }

    @Override
    public Monhoc getMonhocById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Monhoc.class, id);
    }

}
