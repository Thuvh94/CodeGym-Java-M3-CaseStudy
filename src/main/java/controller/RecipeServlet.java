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

@WebServlet(name = "RecipeServlet",urlPatterns = "/FoodBlog")
public class RecipeServlet extends HttpServlet {
    iServiceCategoryImpl iServiceCategory = new iServiceCategoryImpl();
    iServiceRecipeImpl iServiceRecipe = new iServiceRecipeImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                addRecipe(request,response);
                break;

            default:

                break;
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            default:
                displayRecipeList(request,response);
        }
    }


    // Chức năng hiển thị chi tiết bài đăng

    // Chức năng tạo bài đăng
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response){
        List<Category> categoryList = null;
        try {
            categoryList = iServiceCategory.findAll();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/createRecipe.jsp");
            request.setAttribute("categoryList",categoryList);
            requestDispatcher.forward(request,response);
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
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String ingredient = request.getParameter("ingredient");
        int difficulty = Integer.parseInt(request.getParameter("difficulty"));
        System.out.println(difficulty);
        String equipment = request.getParameter("equipment");
        float prepareTime = Float.parseFloat(request.getParameter("prepareTime"));
        System.out.println(prepareTime);


//        private int recipeId;
//        private String title;
//        private String description;
//        private String ingredient;
//        private int difficulty;
//        private float prepareTime;
//        private float cookTime;
//        private float waitingTime;
//        private int yield;
//        private String equipment;
//        private Category categoryId;
//        private Timestamp publishedAt;
//        private Timestamp createdAt;
//        private Timestamp updatedAt;
//        private String coverImg;
//        private int status;
//        private int writerId;

    }
    private void displayRecipeList(HttpServletRequest request, HttpServletResponse response) {
        List<Recipe> recipeList = new ArrayList<>();
        try {
            recipeList = iServiceRecipe.findAll();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/recipeList.jsp");
            request.setAttribute("recipeList",recipeList);
            requestDispatcher.forward(request,response);
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
