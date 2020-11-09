package controller;

import model.Recipe;
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
            case "view":
                showDetail(request,response);
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
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/home.jsp");
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

    private void showDetail(HttpServletRequest request, HttpServletResponse response) {

    }


}

