package CapaPersistencia;

import CapaDomini.Tauler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Maria on 07/11/2015.
 */
public class ControladorTaulerini {
    private String INSERT_TAULER_INI = "INSERT INTO Tauler_ini VALUES (?,?,?,?,?)";
    private String DELETE_TAULERINI = "DELETE FROM tauler_ini WHERE idhidato = ?";

    public void guardar_taulerini(Tauler taulerini)
    {
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/Desktop/basedades.db")) {
            PreparedStatement insert = c.prepareStatement(INSERT_TAULER_INI);
            insert.setInt(1, taulerini.getIdhidato());
            insert.setInt(2, taulerini.tamany());
            insert.setInt(3, taulerini.getNforats());
            insert.setInt(4, taulerini.getNcolocats());
            insert.setString(5, taulerini.guardar_matriz_dao());
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete_taulerini(Integer id) {
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/Desktop/basedades.db")) {
            PreparedStatement delete = c.prepareStatement(DELETE_TAULERINI);
            delete.setInt(1, id);
            delete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
