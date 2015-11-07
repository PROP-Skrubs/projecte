package CapaPersistencia;

import CapaDomini.Tauler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Maria on 07/11/2015.
 */
public class ControladorTauleromplert {
    private String INSERT_TAULER_OMPLERT = "INSERT INTO Tauler_omplert VALUES (?,?,?,?,?)";
    private String DELETE_TAULEROMPLERT = "DELETE FROM tauler_omplert WHERE idhidato = ?";

    public void guardar_tauleromplert(Tauler taulerini, int idhidato)
    {
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/Desktop/basedades.db")) {
            PreparedStatement insert = c.prepareStatement(INSERT_TAULER_OMPLERT);
            insert.setInt(1, idhidato);
            insert.setInt(2, taulerini.tamany());
            insert.setInt(3, taulerini.getNforats());
            insert.setInt(4, taulerini.getNcolocats());
            insert.setString(5, taulerini.guardar_matriz_dao());    //HAy que meter el lleno
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete_tauleromplert(Integer id) {
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/Desktop/basedades.db")) {
            PreparedStatement delete = c.prepareStatement(DELETE_TAULEROMPLERT);
            delete.setInt(1, id);
            delete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
