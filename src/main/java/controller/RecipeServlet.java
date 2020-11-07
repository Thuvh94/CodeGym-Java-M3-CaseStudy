package controller;

import model.Category;
import model.Recipe;
import service.iServiceCategoryImpl;
import service.iServiceRecipeImpl;

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

@WebServlet(name = "RecipeServlet", urlPatterns = "/FoodBlog")
public class RecipeServlet extends HttpServlet {
    iServiceCategoryImpl iServiceCategory = new iServiceCategoryImpl();
    iServiceRecipeImpl iServiceRecipe = new iServiceRecipeImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addRecipe(request, response);
                break;
            default:
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            default:
                displayRecipeList(request, response);
                break;
        }
    }


    // Chức năng hiển thị chi tiết bài đăng

    // Chức năng tạo bài đăng
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = null;
        try {
            categoryList = iServiceCategory.findAll();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/createRecipe.jsp");
            request.setAttribute("categoryList", categoryList);
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

    private void addRecipe(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("add recipe");
        String title = request.getParameter("title");
        System.out.println(title);
        String description = request.getParameter("description");
        System.out.println(description);
        String ingredient = request.getParameter("ingredient");
        System.out.println(ingredient);
        int difficulty = Integer.parseInt(request.getParameter("difficulty"));
        System.out.println("difficulty"+difficulty);
        String equipment = request.getParameter("equipment");
        System.out.println("equipment" + equipment);
        float prepareTime = Float.parseFloat(request.getParameter("prepareTime"));
        System.out.println("prepareTime" + prepareTime);
        float cookTime = Float.parseFloat(request.getParameter("cookTime"));
        System.out.println("cookTime"+cookTime);
        float waitTime = Float.parseFloat(request.getParameter("waitTime"));
        System.out.println("waitTime" + waitTime);
        int yield = Integer.parseInt(request.getParameter("yield"));
        System.out.println("yield"+yield);
        int categoryId = Integer.parseInt(request.getParameter("category"));
        System.out.println("categoryId: "+ categoryId);
//        String coverImg = request.getParameter("coverImg");
//        System.out.println("Cover img: " + coverImg);
        Category category = iServiceCategory.findById(categoryId);
        System.out.println(category);
        Recipe recipe = new Recipe(title, description, ingredient, difficulty,
                prepareTime, cookTime, waitTime, yield, equipment, category);
        System.out.println(recipe);
        try {
            iServiceRecipe.add(recipe);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/recipeDetail.jsp");
        request.setAttribute("recipe", recipe);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayRecipeList(HttpServletRequest request, HttpServletResponse response) {
        List<Recipe> recipeList = new ArrayList<>();
        try {
            recipeList = iServiceRecipe.findAll();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/recipeList.jsp");
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

}
