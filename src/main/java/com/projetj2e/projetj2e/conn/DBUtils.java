package com.projetj2e.projetj2e.conn;

import com.projetj2e.projetj2e.beans.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
    public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException{
        PreparedStatement pstmt = conn.prepareStatement("Select Login,Password from utilisateur " +
                "where Login = ? and  Password = ?");
        pstmt.setString(1,userName);
        pstmt.setString(2,password);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }
  public static UserAccount findUser(Connection conn, String userName) throws SQLException{
      PreparedStatement pstmt = conn.prepareStatement("Select Login,Password from utilisateur " +
              "where Login = ?");
      pstmt.setString(1,userName);
      ResultSet rs = pstmt.executeQuery();
      if(rs.next()){
          String password = rs.getString("Password");
          UserAccount user = new UserAccount();
          user.setUserName(userName);
          user.setPassword(password);
          return user;
      }
      return null;
  }
}
