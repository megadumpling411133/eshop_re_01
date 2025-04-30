package com.example.dao.impl;

import com.example.dao.OrderDao;
import com.example.pojo.entity.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }
}
