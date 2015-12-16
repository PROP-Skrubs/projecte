package CapaPersistencia;

import CapaDomini.Modelo.Tauler;
import CapaDomini.Modelo.TaulerComplert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Aquesta classe s'encarrega de les Funcionalitats amb la BD del Tauler
 * @author Eduard J. Seoane
 */
public class GestorTauler
{
    private static final Connection conn = CapaPersistencia.conn;
    private static final String INSERT_TAULER = "INSERT INTO taulers (" +
            "tamany," +
            "stringCreacio" +
            ") VALUES (?, ?)";
    private static final String COUNT_TAULER = "SELECT COUNT(*) FROM taulers WHERE id=?";
    private static final String DELETE_TAULER = "DELETE FROM taulers WHERE id=?";
    private static final String SELECT_TAULER = "SELECT * FROM taulers WHERE id=?";
/*
    private static final String UPDATE_TAULER = "UPDATE taulers SET" +
            "tamany=?," +
            "stringCreacio=?" +
            "WHERE id=?";
*/

    /**
     * Aquesta funcio comprova si existeix ja un Tauler amb aquell id a la BD
     * @param id
     * @return Retorna true si existeix un tauler, en cas contrari no existeix tauler. Si hi ha mes d'un Tauler a la Bd amb el mateix id, ho diu per pantalla
     */
    public static boolean existeixTauler(int id)
    {
        if (id == -1)
            return false;
        try (PreparedStatement s = conn.prepareStatement(COUNT_TAULER))
        {
            s.setInt(1, id);
            ResultSet resSet = s.executeQuery();
            resSet.next();
            if (resSet.getInt(1) >= 2) throw new RuntimeException("Dos Taulers a la Base de Dades amb la mateixa ID!!");
            return resSet.getInt(1) == 1;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Aquesta funcio comprova si ja existeix un TaulerComplert amb l'id passat per parametre a la BD
     * @param id
     * @return Retorna true si existeix, en cas contrari false
     */
    public static boolean existeixTaulerComplert(int id)
    {
        return existeixTauler(id);
    }

    /**
     * Aquesta funcio retorna el Tauler amb id que es passa per parametre
     * @param id
     * @return Retorna el Tauler amb l'id passat per parametre
     */
    public static Tauler donaTauler(int id)
    {
        Tauler aRetornar = null;
        try (PreparedStatement p = conn.prepareStatement(SELECT_TAULER))
        {
            p.setInt(1, id);
            ResultSet resSet = p.executeQuery();
            if (resSet.next())
            {
                aRetornar = new Tauler();
                aRetornar.setUniqID(id);
                Scanner textCreacio = new Scanner(resSet.getString("stringCreacio"));
                aRetornar.llegeixRepresentacioTextual(textCreacio);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return aRetornar;

    }

    /**
     * Aquesta funcio retorna el Tauler Complert que te com a id la id passada per parametre
     * @param id
     * @return Retorna el Tauler Complert amb l'id passat per parametre
     */
    public static TaulerComplert donaTaulerComplert(int id)
    {
        return new TaulerComplert(donaTauler(id));
    }

    /**
     * Aquesta funcio guarda el Tauler passat per parametre a la BD
     * @param t
     * @return Retorna la ultima clau inserida, per saber la id del Tauler.
     */
    public static int creaTauler(Tauler t)
    {
        try (PreparedStatement p = CapaPersistencia.conn.prepareStatement(INSERT_TAULER))
        {
            p.setInt(1, t.getTamany());
            p.setString(2, t.donaRepresentacioTextual());
            p.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return CapaPersistencia.retornaUltimaClauInserida();

    }

    /**
     * Aquesta funcio guarda el TaulerComplert passat per parametre a la BD
     * @param t
     * @return Retorna la ultima clau inserida, per saber la id del TaulerComplert.
     */
    public static int creaTaulerComplert(TaulerComplert t)
    {
        return creaTauler(t);
    }

    /**
     * Aquesta funcio rep la id del Tauler que es vol eliminar
     * @param id
     * @return Retorna false si no s'ha esborrat cap Tauler, diu quants Taulers s'han esborrat, en cas que hagi sigut mes de un, i en cas que s'hagi esborrat nomes un, retorna true
     */
    public static boolean eliminaTauler(int id)
    {
        try (PreparedStatement s = conn.prepareStatement(DELETE_TAULER))
        {
            s.setInt(1, id);
            int taulersBorrats = s.executeUpdate();
            if (taulersBorrats != 1)
            {
                String problema;
                if (taulersBorrats == 0) return false;
                else problema = String.format("S'han borrat %d taulers!", taulersBorrats);
                throw new RuntimeException(problema);
            }
            return true;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    /**
     * Aquesta funcio rep la id del TaulerComplert que es vol eliminar
     * @param id
     * @return Retorna false si no s'ha esborrat cap TaulerComplert, diu quants TaulerComplerts s'han esborrat, en cas que hagi sigut mes de un, i en cas que s'hagi esborrat nomes un, retorna true
     */
    public static boolean eliminaTaulerComplert(int id)
    {
        return eliminaTauler(id);
    }


}
