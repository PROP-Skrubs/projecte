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
    private static final String CREATE_TABLE_USUARIS = "CREATE TABLE IF NOT EXISTS usuaris (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nomUsuari VARCHAR(30) NOT NULL UNIQUE," +
            "contrasenya VARCHAR(30) NOT NULL," +
            "nomReal VARCHAR(30)" +
            ")";
    private static final String INSERT_USUARI = "INSERT INTO usuaris VALUES (?,?,?,?)";

    private static final String CREATE_TABLE_HIDATO = "CREATE TABLE IF NOT EXISTS hidato (" +
            "idhidato INTEGER PRIMARY KEY ," +
            "id_taulerini INTEGER NOT NULL UNIQUE," +
            "id_tauleromplert INTEGER NOT NULL UNIQUE," +
            "dificultad VARCHAR(30)" +
            ")";
    private static final String INSERT_HIDATO = "INSERT INTO hidato VALUES (?,?,?,?)";

    private static final String CREATE_TABLE_TAULERINI = "CREATE TABLE IF NOT EXISTS tauler_ini (" +
            "id_taulerini INTEGER PRIMARY KEY ," +
            "medida INTEGER NOT," +
            "matriz VARCHAR NOT NULL," +
            ")";
    private static final String INSERT_TAULERINI = "INSERT INTO tauler_ini VALUES (?,?,?)";

    private static final String CREATE_TABLE_TAULEROMP = "CREATE TABLE IF NOT EXISTS tauler_omplert (" +
            "id_tauleromplert INTEGER PRIMARY KEY ," +
            "medida INTEGER NOT," +
            "matriz VARCHAR NOT NULL," +
            ")";
    private static final String INSERT_TAULEROMP = "INSERT INTO tauler_omplert VALUES (?,?,?)";

    private static final String CREATE_TABLE_PARTIDA = "CREATE TABLE IF NOT EXISTS usuaris (" +
            "idpartida INTEGER PRIMARY KEY AUTOINCREMENT," +
            "idhidato INTEGER NOT NULL UNIQUE," +
            "iduser INTEGER NOT NULL," +
            "ncelesresolt INTEGER" +
            "numajud INTEGER," +
            "matriz VARCHAR ," +
            "acabat BOOLEAN" +
            ")";
    private static final String INSERT_PARTIDA = "INSERT INTO partida VALUES (?,?,?,?,?,?,?)";

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



    public static void validarBaseDeDades()
    {
        //Executem tots els CREATE TABLE statements per assegurar-nos que la BD esta en condicions d'operar. Exemple:

        //Falta afegir el codi de la resta de taules
        try (Statement statement = conn.createStatement())
        {
            statement.execute(CREATE_TABLE_USUARIS);
            statement.execute(CREATE_TABLE_HIDATO);
            statement.execute(CREATE_TABLE_TAULERINI);
            statement.execute(CREATE_TABLE_TAULEROMP);
            statement.execute(CREATE_TABLE_PARTIDA);
            //Falta afegir el codi de la resta de taules
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
