package controller;

import service.IWriterService;
import service.WriterServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
    IWriterService iWriterService = new WriterServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "checkLogin":
                checkLogin(request,response);
                break;
            default:
                displayLoginForm(request,response);
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
                displayLoginForm(request,response);
                break;
        }
    }

    private void displayLoginForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/Login.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        RequestDispatcher dispatcher;
//        if (username.equals("admin") && password.equals("admin")) {
//            dispatcher = request.getRequestDispatcher("/FoodBlog");
//            request.setAttribute("message", "Xin chào!");
//            dispatcher.forward(request, response);
////        } else if (username.equals(customerFind.getUsername()) && password.equals(customerFind.getPassword())) {
////            dispatcher = request.getRequestDispatcher("home/home.jsp");
////            request.setAttribute("message", customerFind.getCustomerName());
////            dispatcher.forward(request, response);
//        } else {
//            dispatcher = request.getRequestDispatcher("client/Login.jsp");
//            request.setAttribute("message", "Wrong Information! Please try agian!");
//            dispatcher.forward(request, response);
//        }


        String userName = request.getParameter("username");
        System.out.println(userName);
        String password = request.getParameter("password");
        System.out.println(password);
        boolean isValid = iWriterService.checkLogin(userName,password);
        RequestDispatcher dispatcher;
        if(isValid){
            System.out.println(isValid);
            HttpSession session = request.getSession();
            response.sendRedirect("http://localhost:8080/FoodBlog");
//            session.setAttribute("sessionUsername",userName);
//            dispatcher = request.getRequestDispatcher("/FoodBlog");
////                    dispatcher = request.getRequestDispatcher("/decks");
////        request.setAttribute("message", "Xin chào!");
//        dispatcher.forward(request, response);
        }
        else {
//            RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/Login");
            System.out.println("Không vào isValid");
            dispatcher = request.getRequestDispatcher("client/Login.jsp");
            request.setAttribute("message", "Wrong Information! Please try agian!");
            dispatcher.forward(request, response);
        }
    }
}
