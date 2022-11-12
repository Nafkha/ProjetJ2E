package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.conn.ConnectionUtils;
import com.projetj2e.projetj2e.conn.MyUtils;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import static java.lang.System.out;

@WebFilter(filterName = "jdbcFilter", urlPatterns = { "/*" })
public class JDBCFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
            out.println("Open Connection for : "+req.getServletPath());
            Connection con = null;

            try {
                con = ConnectionUtils.getConnection();
                out.println("Connected");
                MyUtils.storeConnection(request,con);
                chain.doFilter(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
                out.println("Erreur 1");
            } catch (ClassNotFoundException e) {
                out.println("Erreur 2");
                e.printStackTrace();
            }

    }
}
