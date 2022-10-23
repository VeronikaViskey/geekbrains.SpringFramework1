package com.geekbrains.app;

import java.util.List;

public class ProductRepository {
    private List<Product> productList;

    public ProductRepository(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> init(){
        return productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product findProductWithId(int id){
        for (Product product:productList) {
            if(product.id == id){
                return product;
            }
        }
        return new Product(0,"0",0.0);
    }
}
