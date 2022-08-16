package com.wavemaker.training.db.dao;

import com.wavemaker.training.db.connection.MySQLConnectionUtility;
import com.wavemaker.training.db.model.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {
    public List<Address> ListOf() throws SQLException{
        List<Address> addressList = new ArrayList<>() ;
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ADDRESS");
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String state = resultSet.getString("zip_code");
                int zip_code= resultSet.getInt("zip_code");
                addressList.add(new Address(id,street,city,state,zip_code));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("exception caught");
        }finally {
            connection.close();
        }
        return addressList;
    }
    public void insert(Address address) throws SQLException{
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql ="insert into address(id,street,city,state,zip_code) value(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,address.getId());
            statement.setString(2, address.getStreet());
            statement.setString(3, address.getCity());
            statement.setString(4, address.getState());
            statement.setInt(5, address.getZip_code());

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

    public void update(Address address) throws SQLException
    {
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "UPDATE ADDRESS SET street=?, city=? ,state=? ,zip_code =?  WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, address.getStreet());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getState());
            statement.setInt(4, address.getZip_code());
            statement.setInt(5,address.getId());

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

    public void delete(Address address) throws SQLException
    {
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "DELETE FROM ADDRESS where id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,address.getId());
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
    public void search(Address address) throws SQLException{
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql ="SELECT * FROM ADDRESS WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1,address.getId());

            ResultSet rowsInserted = statement.executeQuery();
            while(rowsInserted.next()){
                int id = rowsInserted.getInt("id");
                String street= rowsInserted.getString("street");
                String city = rowsInserted.getString("city");
                String state = rowsInserted.getString("state");
                int zip_code = rowsInserted.getInt("zip_code");

                System.out.println(id +""+street +" "+city+" "+state+" "+zip_code);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("exception ");
        }finally {
            connection.close();
        }
    }
}
