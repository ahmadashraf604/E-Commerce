/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.servlets;

import com.ecommerce.beans.Category;
import com.ecommerce.beans.Product;
import com.ecommerce.beans.User;
import com.ecommerce.daos.DAOCategories;
import com.ecommerce.daos.DaoProduct;
import com.ecommerce.daos.DaoUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ashraf_R
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("category");
        DaoProduct daoProduct = new DaoProduct();
        List<Product> allProduct;
        if (categoryId != null) {
            allProduct = daoProduct.getProducts(Integer.valueOf(categoryId));
        } else {
            allProduct = daoProduct.getAllProduct();
        }

        req.setAttribute("products", allProduct);
        DAOCategories dAOCategories = new DAOCategories();
        List<Category> allCategories = dAOCategories.getAllCategories();
        req.setAttribute("categories", allCategories);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
