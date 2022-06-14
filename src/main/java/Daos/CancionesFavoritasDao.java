package Daos;

import Beans.CancionesFavoritas;

import java.sql.*;
import java.util.ArrayList;

public class CancionesFavoritasDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    public ArrayList<CancionesFavoritas> obtenerListaCancionesFavoritas(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<CancionesFavoritas> listaCancionesFavoritas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT f.idcancion_favorita, f.cancion_idcancion, c.nombre_cancion, c.banda FROM cancion_favorita f, cancion c\n" +
                     "where f.cancion_idcancion = c.idcancion;")) {

            while (rs.next()) {
                int id_cancion= rs.getInt(2);
                String nombre = rs.getString(3);
                String banda = rs.getString(4);

                listaCancionesFavoritas.add(new CancionesFavoritas(id_cancion,nombre,banda));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCancionesFavoritas;
    }
}
