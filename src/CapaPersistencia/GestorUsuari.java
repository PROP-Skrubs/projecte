package CapaPersistencia;

import CapaDomini.Usuari;

import java.sql.*;

/**
 * Created by daniel on 29/10/15.
 */
public class GestorUsuari
{
    private final static Connection conn = CapaPersistencia.conn;
    private final static String INSERT_USUARI = "INSERT INTO usuaris (nomUsuari, contrasenya, nomReal) VALUES (?,?,?)";
    private final static String COUNT_USUARI = "SELECT COUNT(*) FROM usuaris WHERE nomUsuari = ?";
    private final static String DELETE_USUARI = "DELETE FROM usuaris WHERE nomUsuari = ?";
    private final static String SELECT_USUARI = "SELECT * FROM usuaris WHERE nomUsuari = ?";

    //Inserta un nou usuari a la BD

    public static boolean existeixUsuari(String nomUsuari)
    {
        try (PreparedStatement s = conn.prepareStatement(COUNT_USUARI))
        {
            s.setString(1, nomUsuari);
            ResultSet resSet = s.executeQuery();
            resSet.next();
            if (resSet.getInt(1) >= 2) throw new RuntimeException("Dos usuaris a la Base de Dades amb el mateix nom!!");
            return resSet.getInt(1) == 1;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static boolean crearUsuari(Usuari u)
    {
        if (existeixUsuari(u.getNomUsuari()))
            return false;
        //Ja hem comprovat que no hi ha un usuari amb el mateix nom... per tant podem inserir be.
        try (PreparedStatement p = conn.prepareStatement(INSERT_USUARI))
        {
            p.setString(1, u.getNomUsuari());
            p.setString(2, u.getContrasenya());
            p.setString(3, u.getNomReal());
            p.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static boolean eliminarUsuari(String nomUsuari)
    {
        //Per anar be, aquesta funcio nomes l'hauria de poder arribar a cridar l'administrador!!!
        // o potser tambe el usuari per a si mateix (?)
        try (PreparedStatement s = conn.prepareStatement(DELETE_USUARI))
        {
            s.setString(1,nomUsuari);
            int usuarisBorrats = s.executeUpdate();
            if (usuarisBorrats != 1)
            {
                String problema;
                if (usuarisBorrats == 0) return false;
                else problema = String.format("S'han borrat %d usuaris!", usuarisBorrats);
                throw new RuntimeException(problema);
            }
            return true;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Usuari donaUsuari(String nomUsuari)
    {
        Usuari u = null;
        try (PreparedStatement s = CapaPersistencia.conn.prepareStatement(SELECT_USUARI))
        {
            s.setString(1, nomUsuari);
            ResultSet resSet = s.executeQuery();
            if (resSet.next())
            {
                u = new Usuari();
                u.setNomUsuari(resSet.getString(2));
                u.setContrasenya(resSet.getString(3));
                u.setNomReal(resSet.getString(4));
            }
            if (resSet.next()) //Hi ha mes d'un usuari que concorda amb el nom que li ha donat! Error!!!
            {
                throw new RuntimeException("Hi ha mes d'un usuari amb el mateix nom!");
                //Aixo realment no te que ser RuntimeException, sino que hauria de ser normal i handlejada mes amunt...
                // pero *tampoc passara mai* (la taula te UNIQUE constraint), aixi que fuck it.
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return u;
    }
}
