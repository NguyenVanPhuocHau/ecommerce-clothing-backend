package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service;

import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.CartItems;

import java.util.List;

public interface CartService {
    public void addProduct(int idProduct, int idUser, int idColor, int idSize, int quantity);
    public void removeProduct(int idProduct, int idUser, int idColor, int idSize);

    public List<CartItems> findAllCartItemsById(int idUser);
}
