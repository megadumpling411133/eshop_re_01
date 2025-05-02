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

    // ✅ 使用 HQL + fetch join 查出購物車及其明細
    @Override
    public Cart getCartByUserId(String userId) {
        Cart cart = getSession().createQuery(
            /*"from Cart c left join fetch c.details where c.userId = :userId", Cart.class)*/
        	"select distinct c from Cart c " +
            "left join fetch c.details d " +
            "left join fetch d.product " +
            "where c.userId = :userId", Cart.class)
        	.setParameter("userId", userId)
            .uniqueResult();

        // ✅ DEBUG 用
        if (cart != null) {
            System.out.println("✅ Cart 查詢成功, cartId = " + cart.getId());
            if (cart.getDetails() != null) {
                System.out.println("✅ 明細筆數 = " + cart.getDetails().size());
            } else {
                System.out.println("⚠️ 明細為 null");
            }
        } else {
            System.out.println("❌ 查無 Cart, userId = " + userId);
        }

        return cart;
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
    public CartDetail getCartDetail(Integer cartId, long productId) {
        return getSession().createQuery(
                "from CartDetail where cart.id = :cartId and productId = :productId", CartDetail.class)
            .setParameter("cartId", cartId)
            .setParameter("productId", productId)
            .uniqueResult();
    }

    @Override
    public void updateCartDetail(CartDetail detail) {
        getSession().update(detail);
    }
    
    @Override
    public void deleteCartDetailsByCartId(Integer cartId) {
        getSession().createQuery("delete from CartDetail where cart.id = :cartId")
            .setParameter("cartId", cartId)
            .executeUpdate();
    }

}
