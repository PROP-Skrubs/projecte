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
    private static final String CREATE_TABLE_USUARIS = "CREATE TABLE IF NOT EXISTS usuaris (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "nomUsuari VARCHAR NOT NULL UNIQUE,\n" +
            "contrasenya VARCHAR NOT NULL,\n" +
            "nomReal VARCHAR\n" +
            ")";
    private static final String CREATE_TABLE_TAULERS = "CREATE TABLE IF NOT EXISTS taulers (\n" +
            "id INT PRIMARY KEY AUTOINCREMENT,\n" +
            "tamany INTEGER NOT NULL,\n" +
            "stringCreacio VARCHAR\n" +
            ")";
    private static final String CREATE_TABLE_HIDATOS = "CREATE TABLE IF NOT EXISTS hidatos (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "idTauler INTEGER,\n" +
            "idTaulerComplert INTEGER,\n" +
            "dificultat VARCHAR NOT NULL,\n" +
            "FOREIGN KEY (idTauler) REFERENCES taulers (id),\n" +
            "FOREIGN KEY (idTaulerComplert) REFERENCES taulers (id),\n" +
            ")";
    private static final String CREATE_TABLE_PARTIDES = "CREATE TABLE IF NOT EXISTS partides (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "idUsuari INTEGER NOT NULL,\n" +
            "idHidato INTEGER NOT NULL,\n" +
            "idTaulerProgres INTEGER NOT NULL,\n" +
            "nCelesResoltes INTEGER NOT NULL,\n" +
            "numAjudesUtilitzades INTEGER NOT NULL, #te que anar relacionat amb la dificultat\n" +
            "esAcabada BOOLEAN NOT NULL,\n" +
            "FOREIGN KEY (idhidato) REFERENCES hidato (id),\n" +
            "FOREIGN KEY (iduser) REFERENCES usuaris (id),\n" +
            "FOREIGN KEY (idTaulerProgres) REFERENCES taulers(id)\n" +
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
