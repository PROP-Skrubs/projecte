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
    //Important! tots els "CREATE TABLE" han de portar un "IF NOT EXISTS" perque s'executen cada cop que arranca el programa
    private static final String CREATE_TABLE_USUARIS = "CREATE TABLE IF NOT EXISTS usuaris (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nomUsuari VARCHAR(30) NOT NULL UNIQUE," +
            "contrasenya VARCHAR(30) NOT NULL," +
            "nomReal VARCHAR(30)" +
            ")";
    //    private static final String CREATE_TABLE_TAULERS;
    //    private static final String CREATE_TABLE_HIDATOS;
    private static final String CREATE_TABLE_PARTIDES = "CREATE TABLE IF NOT EXISTS partides (" +
            "idPartida INTEGER PRIMARY KEY AUTOINCREMENT," +
            "idUsuari INTEGER NOT NULL," +
            "idHidato INTEGER NOT NULL," +
            "idTaulerProgres INTEGER NOT NULL," +
            ")";

    static Connection conn;

    static //Inicialitzador de la base de dades
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
        //Executem tots els CREATE TABLE statements per assegurar-nos que la BD esta en condicions d'operar.
        try (Statement statement = conn.createStatement())
        {
            statement.execute(CREATE_TABLE_USUARIS);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
