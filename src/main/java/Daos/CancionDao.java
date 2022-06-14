package Daos;

import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class CancionDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    public ArrayList<Cancion> obtenerListaCancion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCancion = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from cancion;")) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String banda = rs.getString(3);

                listaCancion.add(new Cancion(id,nombre,banda));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCancion;
    }

    public ArrayList<Cancion> obtenerListaCancionBanda(String banda2){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCancion = new ArrayList<>();
        String sql = "select * from cancion where banda = ?";
        try (Connection connection = DriverManager.getConnection(url,user,pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1,banda2);

            try(ResultSet rs = pstmt.executeQuery();){
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String banda = rs.getString(3);

                    listaCancion.add(new Cancion(id,nombre,banda));
                }
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCancion;
    }

    public ArrayList<Cancion> obtenerListaCancionesFavoritas(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCancionesFavoritas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT f.cancion_idcancion, c.nombre_cancion, c.banda FROM cancion_favorita f, cancion c\n" +
                     "where f.cancion_idcancion = c.idcancion;")) {

            while (rs.next()) {
                int id_cancion= rs.getInt(1);
                String nombre = rs.getString(2);
                String banda = rs.getString(3);

                listaCancionesFavoritas.add(new Cancion(id_cancion,nombre,banda));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCancionesFavoritas;
    }

    public ArrayList<Cancion> obtenerListaCancionesFavoritas(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCancionesFavoritas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT f.cancion_idcancion, c.nombre_cancion, c.banda FROM cancion_favorita f, cancion c\n" +
                     "where f.cancion_idcancion = c.idcancion;")) {

            while (rs.next()) {
                int id_cancion= rs.getInt(1);
                String nombre = rs.getString(2);
                String banda = rs.getString(3);

                listaCancionesFavoritas.add(new Cancion(id_cancion,nombre,banda));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCancionesFavoritas;
    }
}
