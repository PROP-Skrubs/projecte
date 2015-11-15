package CapaPersistencia;

import java.sql.*;

import CapaDomini.Usuari;
import CapaDomini.Tauler;
import CapaDomini.Hidato;

import javax.swing.plaf.nimbus.State;


/**
 * Created by daniel on 13/10/15.
 */

public class CapaPersistencia
{
    private static final String CREATE_TABLE_USUARIS = "CREATE TABLE IF NOT EXISTS usuaris (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nomUsuari VARCHAR NOT NULL UNIQUE," +
            "contrasenya VARCHAR NOT NULL," +
            "nomReal VARCHAR" +
            ")";
    private static final String CREATE_TABLE_TAULERS = "CREATE TABLE IF NOT EXISTS taulers (" +
            "id INT PRIMARY KEY AUTOINCREMENT," +
            "tamany INTEGER NOT NULL," +
            "stringCreacio VARCHAR" +
            ")";
    private static final String CREATE_TABLE_HIDATOS = "CREATE TABLE IF NOT EXISTS hidatos (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "idTauler INTEGER," +
            "idTaulerComplert INTEGER," +
            "dificultat VARCHAR NOT NULL," +
            "FOREIGN KEY (idTauler) REFERENCES taulers (id)," +
            "FOREIGN KEY (idTaulerComplert) REFERENCES taulers (id)," +
            ")";
    private static final String CREATE_TABLE_PARTIDES = "CREATE TABLE IF NOT EXISTS partides (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "idUsuari INTEGER NOT NULL," +
            "idHidato INTEGER NOT NULL," +
            "idTaulerProgres INTEGER NOT NULL," +
            "nCelesResoltes INTEGER NOT NULL," +
            "numAjudesUtilitzades INTEGER NOT NULL, #te que anar relacionat amb la dificultat" +
            "esAcabada BOOLEAN NOT NULL," +
            "FOREIGN KEY (idhidato) REFERENCES hidato (id)," +
            "FOREIGN KEY (iduser) REFERENCES usuaris (id)," +
            "FOREIGN KEY (idTaulerProgres) REFERENCES taulers(id)" +
            ")";

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

    public static int retornaUltimaClauInserida()
    {
        int aRetornar = -1;
        try (Statement s = conn.createStatement())
        {
            ResultSet resSet = s.executeQuery("last_insert_rowid()");
            if (resSet.next())
                aRetornar = resSet.getInt(1);
            else
                throw new RuntimeException("No hi ha ultima clau inserida?");
        }
        catch (SQLException e)
        {
            throw new RuntimeException("No es pot coneixer l'última clau inserida.",e);
        }
        return  aRetornar;
    }

    public static void validarBaseDeDades()
    {
        //Executem tots els CREATE TABLE statements per assegurar-nos que la BD esta en condicions d'operar. Exemple:

        //Falta afegir el codi de la resta de taules
        try (Statement statement = conn.createStatement())
        {
            statement.execute(CREATE_TABLE_USUARIS);
            statement.execute(CREATE_TABLE_TAULERS);
            statement.execute(CREATE_TABLE_HIDATOS);
            statement.execute(CREATE_TABLE_PARTIDES);
            //Falta afegir el codi de la resta de taules (e.g. estadistiques)
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
