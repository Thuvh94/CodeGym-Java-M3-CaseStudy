package controller;

import model.Category;
import model.CookStep;
import model.Recipe;
import service.Connection;
import service.CategoryServiceImpl;
import service.CookStepServiceImpl;
import service.RecipeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RecipeServlet", urlPatterns = "/FoodBlog")
@MultipartConfig
public class RecipeServlet extends HttpServlet {
    CategoryServiceImpl iServiceCategory = new CategoryServiceImpl();
    RecipeServiceImpl iServiceRecipe = new RecipeServiceImpl();
    CookStepServiceImpl serviceCookStep = new CookStepServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    addRecipe(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "update":
                updateRecipe(request, response);
                break;
            default:
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
            case "create":
                showCreateForm(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "delete":
                deleteRecipe(request, response);
                break;
            case "view":
                viewDetailRecipe(request, response);
                break;
            case "viewByCategory":
                viewRecipesByCategory(request,response);
            default:
                displayRecipeList(request, response);
                break;
        }
    }


    // Chức năng hiển thị chi tiết bài đăng
    private void viewDetailRecipe(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = null;
        try {
            categoryList = iServiceCategory.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(request.getParameter("id"));
        Recipe recipe = iServiceRecipe.findById(id);
        try {
            List<CookStep> cookStepList = serviceCookStep.findAllByRecipeId(recipe);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/recipeDetail.jsp");
            request.setAttribute("recipe", recipe);
            request.setAttribute("cookStepList", cookStepList);
            request.setAttribute("categoryList",categoryList);
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

    private void addRecipe(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        System.out.println("add recipe");
        String title = request.getParameter("title");
        System.out.println(title);
        String description = request.getParameter("description");
        System.out.println(description);
        String ingredient = request.getParameter("ingredient");
        System.out.println(ingredient);
        int difficulty = Integer.parseInt(request.getParameter("difficulty"));
        System.out.println("difficulty" + difficulty);
        float cookTime = Float.parseFloat(request.getParameter("cookTime"));
        System.out.println("cookTime" + cookTime);
        int yield = Integer.parseInt(request.getParameter("yield"));
        System.out.println("yield" + yield);
        int categoryId = Integer.parseInt(request.getParameter("category"));
        System.out.println("categoryId: " + categoryId);
        Category category = iServiceCategory.findById(categoryId);
        System.out.println(category);
        // Xử lý ảnh cover photo
        String coverImg = request.getParameter("coverImg");
        Recipe recipe = new Recipe(title, description, ingredient, difficulty, cookTime, yield, category, coverImg);
        System.out.println(recipe);
        try {
            iServiceRecipe.add(recipe);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = new Connection();
        Statement st = connection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery("SELECT recipeId FROM recipe ORDER BY recipeId DESC LIMIT 1;");
        int recipeId = 0;
        while (resultSet.next()) {
            recipeId = resultSet.getInt(1);
        }
        Recipe newestRecipe = iServiceRecipe.findById(recipeId);
        String[] cookstepContent = request.getParameterValues("cookStep");
        List<CookStep> cookStepList = new ArrayList<>();
        for (int i = 0; i < cookstepContent.length; i++) {
            cookStepList.add(new CookStep(newestRecipe, cookstepContent[i]));
            serviceCookStep.add(new CookStep(newestRecipe, cookstepContent[i]));
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/recipeDetail.jsp");
        request.setAttribute("recipe", recipe);
        request.setAttribute("cookStepList", cookStepList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Show list recipe
    private void displayRecipeList(HttpServletRequest request, HttpServletResponse response) {
        List<Recipe> recipeList = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();
        String search = request.getParameter("search");
        if (search == null) {
            try {
                recipeList = iServiceRecipe.findAll();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            recipeList = iServiceRecipe.findByName(search);
        }
        try {
            categoryList = iServiceCategory.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/recipeList.jsp");
        request.setAttribute("recipeList", recipeList);
        request.setAttribute("categoryList",categoryList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Chức năng update recipe
    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = null;
        List<CookStep> cookStepList = null;
        try {
            categoryList = iServiceCategory.findAll();
            int id = Integer.parseInt(request.getParameter("id"));
            Recipe recipe = iServiceRecipe.findById(id);
            cookStepList = serviceCookStep.findAllByRecipeId(recipe);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/updateRecipe.jsp");
            request.setAttribute("editRecipe", recipe);
            request.setAttribute("categoryList", categoryList);
            request.setAttribute("cookStepList", cookStepList);
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

    private void updateRecipe(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("update recipe");
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        System.out.println(title);
        String description = request.getParameter("description");
        System.out.println(description);
        String ingredient = request.getParameter("ingredient");
        System.out.println(ingredient);
        int difficulty = Integer.parseInt(request.getParameter("difficulty"));
        System.out.println("difficulty" + difficulty);
        float cookTime = Float.parseFloat(request.getParameter("cookTime"));
        System.out.println("cookTime" + cookTime);
        int yield = Integer.parseInt(request.getParameter("yield"));
        System.out.println("yield" + yield);
        int categoryId = Integer.parseInt(request.getParameter("category"));
        System.out.println("categoryId: " + categoryId);
        Category category = iServiceCategory.findById(categoryId);
        System.out.println(category);
        String coverImg = request.getParameter("coverImg");
        Recipe recipe = new Recipe(title, description, ingredient, difficulty, cookTime, yield, category, coverImg);
        System.out.println(recipe);
        try {
            Recipe editedRecipe = iServiceRecipe.findById(id);
            serviceCookStep.deleteCookStepByRecipeId(editedRecipe);
            String[] cookstepContent = request.getParameterValues("cookStep");
            List<CookStep> cookStepList = new ArrayList<>();
            for (int i = 0; i < cookstepContent.length; i++) {
//                cookStepList.add(new CookStep(editedRecipe,cookstepContent[i]));
                serviceCookStep.add(new CookStep(editedRecipe, cookstepContent[i]));
            }
            iServiceRecipe.update(id, recipe);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        displayRecipeList(request, response);
    }

    // Chức năng xóa Recipe
//    private void confirmDeleteRecipe(HttpServletRequest request, HttpServletResponse response){
//
//    }
    private void deleteRecipe(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            iServiceRecipe.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        displayRecipeList(request, response);
    }


    private void viewRecipesByCategory(HttpServletRequest request, HttpServletResponse response) {
        int categoryId = Integer.parseInt(request.getParameter("CategoryId"));
        List<Category> categoryList = null;
        try {
            categoryList = iServiceCategory.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Category category = iServiceCategory.findById(categoryId);
        String categoryName = category.getCategoryName();
        List<Recipe> recipeList = iServiceRecipe.findByCategory(category);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/recipeListByCategory.jsp");
        request.setAttribute("recipeList", recipeList);
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("categoryName",categoryName);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
