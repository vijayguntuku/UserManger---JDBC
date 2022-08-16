package com.wavemaker.training.db.dao;


import com.wavemaker.training.db.connection.MySQLConnectionUtility;
import com.wavemaker.training.db.model.employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {

    public List<employee> ListOf() throws SQLException{
        List<employee> employeeList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String mobile = resultSet.getString("mobile");
                int department_id = resultSet.getInt("department_id");
                int address_id = resultSet.getInt("address_id");
                employeeList.add(new employee(id, name, mobile, department_id, address_id));
            }
        } catch (SQLException e) {
            System.out.println("First Insert data in address and department table");
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return employeeList;
    }



    public void insert(employee employee) throws SQLException{
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql ="INSERT INTO EMPLOYEE(id,name,mobile,department_id,address_id) VALUES(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getMobile());
            statement.setInt(4, employee.getDepartment_id());
            statement.setInt(5, employee.getAddress_id());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("exception ");
        }finally {
            connection.close();
        }
    }

    public void update(employee employee) throws SQLException
    {
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "UPDATE EMPLOYEE SET name=?, mobile=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,employee.getName());
            statement.setString(2,employee.getMobile());
            statement.setInt(3,employee.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            connection.close();
        }

    }

    public void delete(employee employee) throws SQLException
    {
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "DELETE FROM EMPLOYEE WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,employee.getId());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }

    }
    public void search(employee employee) throws SQLException{
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql ="SELECT * FROM EMPLOYEE  id=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1,employee.getId());

              ResultSet rowsInserted = statement.executeQuery();
            while(rowsInserted.next()){
                int id = rowsInserted.getInt("id");
                String name = rowsInserted.getString("name");
                String mobile = rowsInserted.getString("mobile");
                int department_id = rowsInserted.getInt("department_id");
                int address_id = rowsInserted.getInt("address_id");

                System.out.println(id +""+name +" "+mobile +" "+department_id+" "+address_id);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("exception ");
        }finally {
            connection.close();
        }
    }
}
