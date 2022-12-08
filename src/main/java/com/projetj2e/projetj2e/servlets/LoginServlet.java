package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.beans.UserAccount;
import com.projetj2e.projetj2e.conn.DBUtils;
import com.projetj2e.projetj2e.conn.MyUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public static final long serialVersionUID = 1;

    public LoginServlet() {
        super();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount user = null;
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        boolean hasError = false;
        String errorString = null;
        if(userName == null || password == null || userName.length()==0 ||password.length()==0){
            hasError = true;
            errorString = "Username et mot de passe necessaire";
        }else {
            Connection conn = MyUtils.getStoredConnection(request);
            try {
                user = DBUtils.findUser(conn,userName,password);
                if(user == null){
                    hasError = true;
                    errorString = "Login ou mot de passe incorrecte";
                    System.out.println(errorString);
                }
            }catch (SQLException e){
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
                System.out.println(errorString);
            }
        }
        if(hasError){
            user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            request.setAttribute("errprString",errorString);
            request.setAttribute("user",user);
            System.out.println(errorString);

            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);
        }else{
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session,user);
            System.out.println("Succccesss");
            response.sendRedirect(request.getContextPath() + "/userInfo");

        }
    }
}
