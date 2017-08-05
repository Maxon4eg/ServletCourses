package com.akhambir.servlet;

import com.akhambir.controller.Controller;
import com.akhambir.controller.CreateUserController;
import com.akhambir.controller.GetAllCategoriesController;
import com.akhambir.controller.HomeController;
import com.akhambir.factory.Factory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {

    private GetAllCategoriesController getAllCategoriesController;
    private CreateUserController createUserController;
    private Map<Request, Controller> controllerMap = new HashMap<>();

    public void init() {

        controllerMap.put(new Request("/root/home", "GET"), Factory.getHomeController());
        controllerMap.put(new Request("/root/login", "GET"), Factory.getCreateUserController());

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
        Request req = new Request(request.getRequestURI(), request.getMethod());

        try {
            Controller controller = controllerMap.get(req);
            if (controller == null) {
                throw new RuntimeException("Can not handle " + req.getUri());
            }
            ViewModel vm = controller.process(req);
            forward(request, response, vm);
        } catch (Throwable t) {
            //todo process unsupported request
        }


//        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/root/login")) {
//            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
//        }
//
//        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/root/signup")) {
//            request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
//        }
//
//        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/root/profile")) {
//            request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
//        }
//
//        if (request.getMethod().equals("POST") && request.getRequestURI().equals("/root/signup")) {
//            createUserController.process(request, response);
//            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
//        }

        /*
        if (request.getMethod().equals("POST") && request.getRequestURI().equals("/login")) {
            userController.getUser(request, response);
        }*/

//        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/root/categories")) {
//            getAllCategoriesController.process(request, response);
//        }
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, ViewModel vm) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(getView(vm));
        requestDispatcher.forward(request, response);
    }

    private String getView(ViewModel vm) {
        String prefix = "/WEB-INF/views/";
        String sufix = ".jsp";
        return prefix + vm.getView() + sufix;
    }
}
