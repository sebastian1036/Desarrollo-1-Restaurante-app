package com.co.programacion.ejemplosprintboot1.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    Connection con;

    public Connection obtenerConexion() {
        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/restaurante?useSSL=false&serverTimezone=UTC",
                "root",
                ""
            );
            System.out.println("Conexión exitosa");
        } catch (SQLException ex) {
            System.out.println("Error de conexión");
            ex.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {

        Conexion conexion = new Conexion();

        try {
            Connection con = conexion.obtenerConexion();

            ResultSet r = con
                .prepareStatement("SELECT * FROM cliente")
                .executeQuery();

            System.out.println("LISTA DE CLIENTES:");

            while (r.next()) {
                System.out.println(
                    "ID: " + r.getInt("id") +
                    " | Nombre: " + r.getString("nombre") +
                    " | Email: " + r.getString("email") +
                    " | Tel: " + r.getString("telefono")
                );
            }

        } catch (Exception e) {
            System.out.println("Error en ejecución: " + e.getMessage());
        }
    }
}