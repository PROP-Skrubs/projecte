package CapaPersistencia;

import java.sql.*;

import CapaDomini.Usuari;
import CapaDomini.Tauler;
import CapaDomini.Hidato;


/**
 * Created by daniel on 13/10/15.
 */

public class CapaPersistencia
{
    private String INSERT_USUARI = "INSERT INTO usuaris VALUES (?,?,?,?)";
    static Connection conn;

    static
    {
        try
        {
            //jbdc:sqlite:<pathAlFitxer.db>
            conn = DriverManager.getConnection("jdbc:sqlite:basedades.db");
        }
        catch (SQLException e)
        {
            throw new RuntimeException("No s'ha pogut connectar a la Base de Dades!", e);
        }
        validarBaseDeDades();
    }

    private static void validarBaseDeDades()
    {
        //Executem tots els CREATE TABLE statements per assegurar-nos que la BD esta en condicions d'operar. Exemple:

        String usuarisCreateTable = "CREATE TABLE IF NOT EXISTS usuaris (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomUsuari VARCHAR(30) NOT NULL UNIQUE," +
                "contrasenya VARCHAR(30) NOT NULL," +
                "nomReal VARCHAR(30)" +
                ")";
        //Falta afegir el codi de la resta de taules
        try (Statement statement = conn.createStatement())
        {
            statement.execute(usuarisCreateTable);
            //Falta afegir el codi de la resta de taules
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
