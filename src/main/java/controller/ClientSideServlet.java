package controller;

import model.Category;
import model.CookStep;
import model.Recipe;
import service.CategoryService;
import service.CategoryServiceImpl;
import service.CookStepServiceImpl;
import service.RecipeServiceImpl;

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

@WebServlet(name = "ClientSideServlet", urlPatterns = "/RecipeBlog")
public class ClientSideServlet extends HttpServlet {
    CategoryServiceImpl iServiceCategory = new CategoryServiceImpl();
    RecipeServiceImpl iServiceRecipe = new RecipeServiceImpl();
    CookStepServiceImpl serviceCookStep = new CookStepServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
            case "viewAllRecipes":
                viewAllRecipes(request,response);
                break;
            case "viewAllCategories":
                showAllCategories(request,response);
                break;
            case "viewDetail":
                viewDetail(request,response);
                break;
            case "viewRecipesByCategory":
                viewRecipesByCategory(request,response);
                break;
            default:
                displayRecipeList(request, response);
                break;
        }
    }


    private void displayRecipeList(HttpServletRequest request, HttpServletResponse response) {
        List<Recipe> recipeList = new ArrayList<>();
        try {
            recipeList = iServiceRecipe.findAll();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/ClientHome.jsp");
            request.setAttribute("recipeList", recipeList);
            requestDispatcher.forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAllCategories(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = new ArrayList<>();
        try {
            categoryList = categoryService.findAll();
//                int number = categoryService.
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/CategoryList.jsp");
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

    private void viewAllRecipes(HttpServletRequest request, HttpServletResponse response) {
        List<Recipe> recipeList = new ArrayList<>();
        try {
            recipeList = iServiceRecipe.findAll();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/RecipeList.jsp");
            request.setAttribute("recipeList", recipeList);
            requestDispatcher.forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Recipe recipe = iServiceRecipe.findById(id);
        try {
            List<CookStep> cookStepList = serviceCookStep.findAllByRecipeId(recipe);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/ViewDetail.jsp");
            request.setAttribute("recipe", recipe);
            request.setAttribute("cookStepList", cookStepList);
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


    private void viewRecipesByCategory(HttpServletRequest request, HttpServletResponse response) {
        int categoryId = Integer.parseInt(request.getParameter("id"));
//        List<Category> categoryList = null;
        Category category = iServiceCategory.findById(categoryId);
        List<Recipe> recipeList = iServiceRecipe.findByCategory(category);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/RecipeList.jsp");
        request.setAttribute("recipeList", recipeList);
        request.setAttribute("category",category);
//        request.setAttribute("categoryList",categoryList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

