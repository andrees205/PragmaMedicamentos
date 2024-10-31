/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class cn {

    Connection conexion;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pragama_db?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error" + e);
        }
        return conexion;
    }

}