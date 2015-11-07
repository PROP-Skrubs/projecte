package CapaPersistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Maria on 07/11/2015.
 */
public class ControladorPartida {
    private String INSERT_PARTIDA = "INSERT INTO Partida VALUES (?,?,?,?,?,?)";
    private String DELETE_PARTIDA = "DELETE FROM partida WHERE idhidato = ?";

    public void guardar_partida(int idpartida, int idhidato, int nceldas, double temps, int numajudas,String matriz)
    {
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/Desktop/basedades.db")) {
            PreparedStatement insert = c.prepareStatement(INSERT_PARTIDA);
            insert.setInt(1, idpartida);
            insert.setInt(2, idhidato);
            insert.setInt(3, nceldas);
            insert.setDouble(4, temps);
            insert.setInt(5, numajudas);
            insert.setString(6, matriz);
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete_partida(Integer id) {
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/Desktop/basedades.db")) {
            PreparedStatement delete = c.prepareStatement(DELETE_PARTIDA);
            delete.setInt(1, id);
            delete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
