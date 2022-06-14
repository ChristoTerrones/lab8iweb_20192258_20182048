package Daos;

import Beans.Recomendados;

import java.sql.*;
import java.util.ArrayList;

public class RecomendadosDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    public ArrayList<Recomendados> obtenerListaReco(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Recomendados> listaReco = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select idcancion, nombre_cancion, banda from cancion c, reproduccion r\n" +
                     "where c.idcancion = r.cancion_idcancion\n" +
                     "group by cancion_idcancion\n" +
                     "having count(*) >2 \n" +
                     "order by count(*) desc;")) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String banda = rs.getString(3);

                listaReco.add(new Recomendados(id,nombre,banda));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaReco;
    }
}
