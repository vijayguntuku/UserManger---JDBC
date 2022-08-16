package com.wavemaker.training.db.dao;

import com.wavemaker.training.db.connection.MySQLConnectionUtility;
import com.wavemaker.training.db.model.department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    public List<department> listOfdepartment() throws SQLException {
        List<department> departmentList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM DEPARTMENT");
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String Locality = resultSet.getString("Locality");
                departmentList.add(new department(id, name,Locality));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("exception caught");
        }finally {
            connection.close();
        }
        return departmentList;
    }

    public void insert(department department) throws SQLException{
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql ="INSERT INTO DEPARTMENT(id,name,locality) VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,department.getId());
            statement.setString(2, department.getName());
            statement.setString(3, department.getLocality());;

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

    public void update(department department) throws SQLException
    {
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "UPDATE DEPARTMENT SET name=?, locality=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,department.getName());
            statement.setString(2,department.getLocality());
            statement.setInt(3,department.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }

    }

    public void delete(department department) throws SQLException {
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "DELETE FROM DEPARTMENT WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,department.getId());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            connection.close();
        }

    }
    public void search(department department) throws SQLException{
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql ="SELECT * FROM DEPARTMENT id=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1,department.getId());

            ResultSet rowsInserted = statement.executeQuery();
            while(rowsInserted.next()){
                int id = rowsInserted.getInt("id");
                String name = rowsInserted.getString("name");
                String locality = rowsInserted.getString("locality");

                System.out.println(id +" "+name +" "+locality +" ");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("exception ");
        }finally {
            connection.close();
        }
    }
}


