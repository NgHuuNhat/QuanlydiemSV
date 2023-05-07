/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhn.repository.impl;

import com.nhn.pojo.User;
import com.nhn.repository.UserRepository;
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
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@PropertySource("classpath:databases.properties")
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<User> getUsers(Map<String, String> params) {

        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("fullname").as(String.class), String.format("%%%s%%", kw));
                Predicate p2 = b.like(root.get("username").as(String.class), String.format("%%%s%%", kw));
                Predicate p3 = b.like(root.get("lop").as(String.class), String.format("%%%s%%", kw));
                Predicate p4 = b.like(root.get("mssv").as(String.class), String.format("%%%s%%", kw));
                Predicate p5 = b.like(root.get("roleId").get("description").as(String.class), String.format("%%%s%%", kw));
                Predicate p6 = b.or(p1, p2, p3, p4, p5);
                q.where(p6);
                predicates.add(p6);
            }

            String roleId = params.get("roleId");
            if (roleId != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("roleId"), Integer.parseInt(roleId));
                predicates.add(p);
            }
            q.where(predicates.toArray(new Predicate[]{}));
        }

        q.orderBy(b.desc(root.get("id")));
        Query query = s.createQuery(q);
        List<User> users = query.getResultList();
        return users;

    }

    @Override
    public User getUserById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(User.class, id);
    }

    @Override
    public boolean addOrUpdateUser(User u) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (u.getId() > 0) {
                s.update(u);
            } else {
                s.save(u);
            }
            return true;
        } catch (HibernateException ex) {
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        User u = this.getUserById(id);
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.delete(u);
            return true;
        } catch (HibernateException ex) {
            return false;
        }
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        q.where(b.equal(root.get("username"), username));

        Query query = s.createQuery(q);
        return (User) query.getSingleResult();
    }
}
