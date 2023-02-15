package com.stock.repos;

import com.stock.entities.Product;
import com.stock.entities.User;
import com.stock.managers.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepo {

    public User checkUser(String usrName, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("SELECT USR_ID, USR_FULL_NAME, EMAIL FROM USERS WHERE USR_NAME = ? and USR_PASSWORD = ?");
            stmt.setString(1, usrName);
            stmt.setString(2, password);

            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsrId(rs.getInt("USR_ID"));
                user.setUsrFullName(rs.getString("USR_FULL_NAME"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
        return user;
    }

}
