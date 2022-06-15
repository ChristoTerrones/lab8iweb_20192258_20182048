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

    public void agregarFavorito(String id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO `lab6sw1`.`cancion_favorita` (`cancion_idcancion`) VALUES (?);";
        try (Connection connection = DriverManager.getConnection(url,user,pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);){

            pstmt.setInt(1,Integer.parseInt(id));
            pstmt.executeUpdate(); //Es update porque es para insert, update y delete

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
    }
    public void borrarFavorito(String id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "delete from cancion_favorita where cancion_idcancion = ?;";
        try (Connection connection = DriverManager.getConnection(url,user,pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);){

            pstmt.setInt(1,Integer.parseInt(id));
            pstmt.executeUpdate(); //Es update porque es para insert, update y delete

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }

    }
    public ArrayList<Cancion> obtenerlistas(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT idplaylist FROM playlist\n" +
                     "group by idplaylist")) {

            while (rs.next()) {
                String nombrelista = rs.getString(1);

                listas.add(new Cancion(nombrelista));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listas;
    }
    public ArrayList<Cancion> obtenerListasFiltradas(String nombrelista2){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCancion = new ArrayList<>();
        String sql = "SELECT p.idplaylist, c.nombre_cancion FROM playlist p, cancion c where idplaylist= ?\n" +
                "and p.cancion_idcancion= c.idcancion;";
        try (Connection connection = DriverManager.getConnection(url,user,pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1,nombrelista2);

            try(ResultSet rs = pstmt.executeQuery();){
                while (rs.next()) {
                    String nombrelista = rs.getString(1);
                    String nombrecancion = rs.getString(2);

                    listaCancion.add(new Cancion(nombrelista,nombrecancion));
                }
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCancion;
    }
    public ArrayList<Cancion> obtenerCancionAgregar(String nombre2){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCancion = new ArrayList<>();
        String sql = "SELECT c.idcancion, p.idplaylist FROM cancion c, playlist p where nombre_cancion= ?\n" +
                "group by p.idplaylist;";
        try (Connection connection = DriverManager.getConnection(url,user,pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1,nombre2);

            try(ResultSet rs = pstmt.executeQuery();){
                while (rs.next()) {
                    int idcancion = rs.getInt(1);
                    String idplaylist = rs.getString(2);
                    listaCancion.add(new Cancion(idcancion,idplaylist));
                }
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCancion;
    }

    public void agregarlista(String id, String nomlista){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO `lab6sw1`.`playlist` (`idplaylist`, `cancion_idcancion`) VALUES (?, ?);";
        try (Connection connection = DriverManager.getConnection(url,user,pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);){

            pstmt.setString(1,nomlista);
            pstmt.setInt(2,Integer.parseInt(id));
            pstmt.executeUpdate(); //Es update porque es para insert, update y delete

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
    }
    public void crearNuevaLista(String nomlista, String id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO `lab6sw1`.`playlist` (`idplaylist`, `cancion_idcancion`) VALUES (?, ?);";
        try (Connection connection = DriverManager.getConnection(url,user,pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);){

            pstmt.setString(1,nomlista);
            pstmt.setInt(2,Integer.parseInt(id));
            pstmt.executeUpdate(); //Es update porque es para insert, update y delete

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
    }


}
