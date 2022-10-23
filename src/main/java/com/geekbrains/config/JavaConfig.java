package com.geekbrains.config;

import com.geekbrains.app.Cart;
import com.geekbrains.app.Product;
import com.geekbrains.app.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class JavaConfig {

    @Bean
    public Cart cart(){
        return new Cart(new ArrayList<Product>(),productRepository());
    }

    @Bean
    public ProductRepository productRepository(){
        List<Product> productList = new ArrayList<>();
        List<Integer> generatedIds = new ArrayList<>();
        for(int i = 1 ;i < 6;i++){
            int id = (int)(Math.random() * ( 11 - 2 ));
            while(generatedIds.contains(id)){
                id = (int)(Math.random() * ( 11 - 2 ));
            }
            productList.add(new Product(id,String.format("product %d", i),1000 * new Random().nextDouble()));
            generatedIds.add(id);
        }
         return new ProductRepository(productList);
    }

}
