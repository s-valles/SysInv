package net.javatec.sysinv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javatec.sysinv.model.Systema;

public class SystemaDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_SYSTEMS_SQL = "INSERT INTO systems" + "  (name, serialNumber, location) VALUES " +
        " (?, ?, ?);";

    private static final String SELECT_SYSTEM_BY_ID = "select id,name,serialNumber,location from systems where id =?";
    private static final String SELECT_ALL_SYSTEMS = "select * from systems";
    private static final String DELETE_SYSTEMS_SQL = "delete from systems where id = ?;";
    private static final String UPDATE_SYSTEMS_SQL = "update systems set name = ?,serialNumber= ?, location =? where id = ?;";

    public SystemaDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertSystema(Systema systema) throws SQLException {
        System.out.println(INSERT_SYSTEMS_SQL);

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SYSTEMS_SQL)) {
            preparedStatement.setString(1, systema.getName());
            preparedStatement.setString(2, systema.getSerialNumber());
            preparedStatement.setString(3, systema.getLocation());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Systema selectSystema(int id) {
        Systema systema = null;
        
        try (Connection connection = getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SYSTEM_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            
            ResultSet rs = preparedStatement.executeQuery();

            
            while (rs.next()) {
                String name = rs.getString("name");
                String serialNumber = rs.getString("serialNumber");
                String location = rs.getString("location");
                systema = new Systema(id, name, serialNumber, location);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return systema;
    }

    public List < Systema > selectAllSystems() {

        
        List < Systema > systems = new ArrayList < > ();
       
        try (Connection connection = getConnection();

          
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SYSTEMS);) {
            System.out.println(preparedStatement);
         
            ResultSet rs = preparedStatement.executeQuery();

            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String serialNumber = rs.getString("serialNumber");
                String location = rs.getString("location");
                systems.add(new Systema(id, name, serialNumber, location));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return systems;
    }

    public boolean deleteSystem(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_SYSTEMS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateSystema(Systema systema) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_SYSTEMS_SQL);) {
            statement.setString(1, systema.getName());
            statement.setString(2, systema.getSerialNumber());
            statement.setString(3, systema.getLocation());
            statement.setInt(4, systema.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}