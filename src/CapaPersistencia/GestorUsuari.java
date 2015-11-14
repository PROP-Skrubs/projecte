package CapaPersistencia;

import CapaDomini.Usuari;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 29/10/15.
 */
public class GestorUsuari
{
    private String INSERT_USUARI = "INSERT INTO usuaris VALUES (?,?,?,?)";
    private String CHECK_EXISTEIX = "SELECT nomUsuari FROM usuaris where nomUsuari = ?";
    private String DELETE_USUARI = "DELETE FROM usuaris WHERE nomUsuari = ?";
    private String GET_USUARI = "SELECT * FROM usuaris WHERE nomUsuari = ?";

    //Inserta un nou usuari a la BD
    private void guardar_usuari(Usuari user)
    {
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/Desktop/basedades.db")) {
            PreparedStatement insert = c.prepareStatement(INSERT_USUARI);
            insert.setInt(1, user.getUniqID());
            insert.setString(2, user.getNomUsuari());
            insert.setString(3, user.getContrasenya());
            insert.setString(4, user.getNomReal());
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Mira si hi ha ya un usuari amb aquell mateix id a la BD
    public boolean user_repe (String nomUsuari){
        Boolean b = true;
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/Desktop/prueba.db")) {
            PreparedStatement consulta = c.prepareStatement(CHECK_EXISTEIX);
            consulta.setString(1, nomUsuari);
            ResultSet rs = consulta.executeQuery();
            if(rs.next()) b = false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return b;
    }

    public void delete_usuari(String nomusuari) {
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/Desktop/basedades.db")) {
            PreparedStatement delete = c.prepareStatement(DELETE_USUARI);
            delete.setString(1, nomusuari);
            delete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Usuari donaUsuari(String nomUsuari)
    {
        Usuari u = null;
        try (Statement s = CapaPersistencia.conn.createStatement();
             ResultSet resSet = s.executeQuery("SELECT * FROM usuaris u WHERE u.nomUsuari = '" + nomUsuari + "'"))
        {
            if (resSet.next())
            {
                u = new Usuari();
                u.setNomUsuari(resSet.getString(2));
                u.setContrasenya(resSet.getString(3));
                u.setNomReal(resSet.getString(4));
            }
            if (resSet.next())
            {
                //Hi ha mes d'un usuari que concorda amb el nom que li ha donat! Error!!!
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

    public Usuari getusuari(String nusuari) {
        Usuari u  = new Usuari();
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/Desktop/prueba.db")) {
            PreparedStatement consulta = c.prepareStatement(GET_USUARI);
            consulta.setString(1, nusuari);
            try (ResultSet rs = consulta.executeQuery()) {
                u.setUniqID(rs.getInt(1));
                u.setNomUsuari(rs.getString(2));
                u.setContrasenya(rs.getString(3));
                u.setNomReal(rs.getString(4));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
