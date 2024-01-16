/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class AdminDAO extends DBContext{

    public Admin loginByEmail(String emailAddress, String password) {
        Admin admin = new Admin();
        // lấy dữ liệu bảng product+ category
        String sql = "SELECT * FROM admins WHERE email_address = ? AND password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, emailAddress);
            st.setString(2, password);
            try (ResultSet resultSet = st.executeQuery()) {
                if (resultSet.next()) {
                    // Admin found, create an Admin object and return it
                    return mapResultSetToAdmin(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly in your application
        }

        return null; // Return null if login fails
    }

    public List<Admin> getAllAdmins() {
        List<Admin> admins  = new ArrayList<>();
        // lấy dữ liệu bảng product+ category
        String sql = "SELECT * FROM admins ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Admin admin = mapResultSetToAdmin(resultSet);
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly in your application
        }
        
        return admins;
    }
    
     // Helper method to map ResultSet to Admin object
    private Admin mapResultSetToAdmin(ResultSet resultSet) throws SQLException {
        return new Admin(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("email_address"),
                resultSet.getString("phone_number"),
                resultSet.getString("password"),
                resultSet.getInt("role_id"),
                resultSet.getString("image"),
                resultSet.getTime("date_of_birth"),
                resultSet.getInt("gender"),
                resultSet.getString("city"),
                resultSet.getString("district"),
                resultSet.getString("commune"),
                resultSet.getString("detail"),
                resultSet.getString("longitude"),
                resultSet.getString("latitude"),
                resultSet.getTime("create_at"),
                resultSet.getTime("modify_at"),
                resultSet.getInt("is_locked")
        );
    }
    
        public static void main(String[] args) {
        AdminDAO u = new AdminDAO();
        Admin c = u.loginByEmail("admin@fpt.edu.vn", "123456");
            System.out.println(c);
//        User a = u.loginByName("tienduc", "1234567");
//        u.addAccount("TranLoan", "jknk", "Nam Định", "0913927101", "0", "1");
//        u.EditAccount("13", "TranLoan", "jknk", "Nam Định", "0913927101", "0", "1");
//        List<User> list = u.getAll();
//        int t = u.getTotalAccount();
//        List<User> lista = u.pagingAccount15(1);
//        for (User o : lista) {
//            System.out.println(o);
//        }
//
//        User lID = u.getAccountByID("3");
//        System.out.println(t);
//        System.out.println(a);
//        System.out.println(lID);
    }
}
