package com.akhambir.servlet;

import com.akhambir.controller.CreateUserController;
import com.akhambir.controller.GetAllCategoriesController;
import com.akhambir.factory.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    private GetAllCategoriesController getAllCategoriesController;
    private CreateUserController createUserController;

    public void init() {
        getAllCategoriesController = Factory.getAllCategoriesController();
        createUserController = Factory.getCreateUserController();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/root/home")) {
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        }

        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/root/login")) {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }

        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/root/signup")) {
            request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
        }

        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/root/profile")) {
            request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
        }

        if (request.getMethod().equals("POST") && request.getRequestURI().equals("/root/signup")) {
            createUserController.process(request, response);
            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
        }

        /*if (request.getMethod().equals("POST") && request.getRequestURI().equals("/login")) {
            userController.getUser(request, response);
        }*/

        if(request.getMethod().equals("GET") && request.getRequestURI().equals("/root/categories")) {
            getAllCategoriesController.process(request, response);
        }
    }
}
