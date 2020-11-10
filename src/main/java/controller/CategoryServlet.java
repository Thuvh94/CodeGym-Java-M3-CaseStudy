package controller;

import model.Category;
import model.Recipe;
import service.CategoryService;
import service.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CategoryServlet",urlPatterns ="/Category")
public class CategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                updateCategory(request, response);
                break;
            case "create":
                addCategory(request,response);
                break;
            default:
                System.out.println("default");
                break;
        }
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                displayCategoryList(request, response);
                break;
        }
    }

    private void displayCategoryList(HttpServletRequest request, HttpServletResponse response) {
            List<Category> categoryList = new ArrayList<>();
            try {
                categoryList = categoryService.findAll();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/categoryList.jsp");
                request.setAttribute("categoryList", categoryList);
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) {
        String newName = request.getParameter("newInputName");
        categoryService.add(newName);
        displayCategoryList(request,response);
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) {
        String newName = request.getParameter("newInputName");
        System.out.println(newName);
        int id = Integer.parseInt(request.getParameter("editedId"));
        System.out.println(id);
        categoryService.update(id, newName);
        displayCategoryList(request,response);
    }
}

