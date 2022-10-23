package com.geekbrains.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("com/geekbrains/config");

        Cart cart = context.getBean(Cart.class);
        System.out.println("List of all products: \n" + cart.productRepository.getProductList().toString());
        Scanner scanner = new Scanner(System. in );
        int answer = 0;
        int id = 0;
        while(answer !=3) {
            System.out.println("\nIf you want to add some product, type '1'");
            System.out.println("If you want to remove some product, type '2'");
            System.out.println("If you want to exit,type '3'");
            answer = scanner.nextInt();
            if(answer == 1){
                System.out.println("enter id of the product");
                id = scanner.nextInt();
                System.out.println(cart.addProductWithId(id));
            }else if(answer == 2){
                System.out.println("enter id of the product");
                id = scanner.nextInt();
                System.out.println(cart.deleteProductWithId(id));
            }else if(answer != 3){
                System.out.println("invalid input");
            }
        }
        System.out.println("ciao");
    }
}
