package com.example.dao.impl;

import com.example.dao.CartDao;
import com.example.pojo.entity.Cart;
import com.example.pojo.entity.CartDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Cart getCartByUserId(String userId) {
        return getSession().createQuery("from Cart where userId = :userId", Cart.class)
            .setParameter("userId", userId)
            .uniqueResult();
    }


    @Override
    public void saveCart(Cart cart) {
        getSession().save(cart);
    }

    @Override
    public void saveCartDetail(CartDetail detail) {
        getSession().save(detail);
    }

    @Override
    public CartDetail getCartDetail(Integer cartId, Integer productId) {
        return getSession().createQuery(
            "from CartDetail where cart.cartId = :cartId and productId = :productId", CartDetail.class)
            .setParameter("cartId", cartId)
            .setParameter("productId", productId)
            .uniqueResult();
    }

    @Override
    public void updateCartDetail(CartDetail detail) {
        getSession().update(detail);
    }
}
