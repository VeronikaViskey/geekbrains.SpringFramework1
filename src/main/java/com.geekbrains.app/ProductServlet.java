package com.geekbrains.app;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<html><body>");
        for(int i = 1 ;i < 10;i++){

            Product product = new Product((int)(Math.random() * ( 11 - 1 )),String.format("product %d", i),1000 * new Random().nextDouble());
            printWriter.write("<h1>id: = " + product.id + ", title = " + product.title + ", price = " + product.cost + "</h1>");
        }
        printWriter.write("</html></body>");
        printWriter.close();
    }

}
