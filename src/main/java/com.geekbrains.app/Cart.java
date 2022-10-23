package com.geekbrains.app;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> cartList;
    ProductRepository productRepository;

    public Cart(List<Product> cart, ProductRepository productRepository) {
        this.cartList = cart;
        this.productRepository = productRepository;
    }

    public String addProductWithId(int id){
        Product product = productRepository.findProductWithId(id);
        if(product.id == 0){
            return "unable to add, product was not found";
        }
        cartList.add(product);
        return product.toString() + " added to the cart. " + "Products in a cart: " + cartList.size();
    }

    public String deleteProductWithId(int id){
        Product product = productRepository.findProductWithId(id);
        if(product.id == 0){
            return "unable to add, product was not found";
        }else if(!cartList.remove(product)){
            return "unable to remove, product was not in a cart";
        }
        return product.toString() + "deleted from the cart. " + "Products in a cart: " + cartList.size();
    }
}

