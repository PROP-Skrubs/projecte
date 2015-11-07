package CapaPersistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Maria on 07/11/2015.
 */
public class ControladorHidato {
    private String INSERT_HIDATO = "INSERT INTO hidato VALUES (?,?)";
    private String DELETE_HIDATO = "DELETE FROM hidato WHERE id = ?";

    public void guardar_hidato(int idhidato, String dificultad)
    {
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/Desktop/basedades.db")) {
            PreparedStatement insert = c.prepareStatement(INSERT_HIDATO);
            insert.setInt(1, idhidato);
            insert.setString(2, dificultad);
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete_hidato(Integer idhidato) {
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/Desktop/basedades.db")) {
            PreparedStatement delete = c.prepareStatement(DELETE_HIDATO);
            delete.setInt(1, idhidato);
            delete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
