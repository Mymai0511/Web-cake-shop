/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class CustomerDAO extends DBContext{

    public Customer loginByEmail(String emailAddress, String password) {
        Customer customer = new Customer();
        String sql = "SELECT * FROM customers WHERE email_address = ? AND password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, emailAddress);
            st.setString(2, password);
            try (ResultSet resultSet = st.executeQuery()) {
                if (resultSet.next()) {
                    // Customer found, create an Customer object and return it
                    return mapResultSetToCustomer(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly in your application
        }

        return null; // Return null if login fails
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers  = new ArrayList<>();
        // lấy dữ liệu bảng product+ category
        String sql = "SELECT * FROM customers ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Customer customer = mapResultSetToCustomer(resultSet);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly in your application
        }
        
        return customers;
    }
    
     // Helper method to map ResultSet to Customer object
    private Customer mapResultSetToCustomer(ResultSet resultSet) throws SQLException {
        return new Customer(
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
}
