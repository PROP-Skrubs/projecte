package CapaPersistencia;


import CapaDomini.Ranking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by oriol on 7/12/15.
 */
public class GestorRanking {
    private final static Connection conn = CapaPersistencia.conn;

    private final static String INSERT_RANQUING = "INSERT INTO ranquing (nomUsuari, idHidato, temps, dificultat) VALUES (?,?,?,?)";

    private final static String SELECT_USUARIS_PER_HIDATO = "SELECT nomUsuari FROM ranquing WHERE idHidato = ? ORDER BY temps ASC LIMIT=10";
    private final static String SELECT_PERSONES_PER_DIFICULTAT = "SELECT  nomUsuari FROM ranquing WHERE dificultat = ? ORDER BY temps ASC LIMIT=10";
    private final static String SELECT_HIDATOS_PER_COPS_RESOLT = "SELECT  idHidato FROM ranquing GROUP BY idHidato ORDER BY COUNT(*) DESC LIMIT=10";


    public static boolean insertRanquing(Ranking r)
    {
        try (PreparedStatement p = conn.prepareStatement(INSERT_RANQUING))
        {
            p.setString(1, r.getnomUsuari());
            p.setInt(2, r.getIdHidato());
            p.setInt(3, r.getTemps());
            p.setString(4, r.getDificultat());
            p.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }

    /**
     * Aquesta funcio selecciona de la BD els usuaris que han resolt un Hidato h amb menor temps i no han utilitzat cap ajuda
     *
     * @param idHidato
     * @return Retorna un ArrayList amb les ids dels deu usuaris que han resolt un Hidato h amb un menor temps.
     * El tamany maxim possible del array sera 10.
     */
    public static ArrayList<String> getNomUsuarisPerHidato(int idHidato) {
        ArrayList<String> array = new ArrayList<String>();
        try (PreparedStatement s = conn.prepareStatement(SELECT_USUARIS_PER_HIDATO)) {
            s.setInt(1, idHidato);
            ResultSet resSet = s.executeQuery();
            while (resSet.next()) {
                String nom = resSet.getString("nomUsuari");
                array.add(nom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return array;
    }

    /**
     * Aquesta funcio selecciona els usuaris que han resolt menor temps qualsevol Hidato amb una certa dificultat i no han utilitzat cap ajuda
     *
     * @param dificultat
     * @return Retorna un ArrayList amb les ids dels deu usuaris que han resolt un Hidato h amb un menor temps i una donada dificultat.
     * El tamany maxim possible del array sera 10.
     */
    public static ArrayList<String> getNomUsuarisPerDificultat(String dificultat) {
        ArrayList<String> result = new ArrayList<String>();
        try (PreparedStatement s = conn.prepareStatement(SELECT_PERSONES_PER_DIFICULTAT)) {
            s.setString(1, dificultat);
            ResultSet resSet = s.executeQuery();
            while (resSet.next()) {
                String nom = resSet.getString("nomUsuari");
                result.add(nom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


    /**
     * Aquesta funcio selecciona de la BD el Hidatos que han estat mes cops resolts i no han utilitzat cap ajuda
     *
     * @return Retorna un ArrayList amb les ids dels Hidatos que han estat mes cops resolt.
     * El tamany maxim possible del array sera 10.
     */
    public static ArrayList<Integer> getIdHidatosMesCopsResolts() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        try (PreparedStatement s = conn.prepareStatement(SELECT_HIDATOS_PER_COPS_RESOLT)) {
            ResultSet resSet = s.executeQuery();
            while (resSet.next()) {
                int i = resSet.getInt("idHidato");
                array.add(i);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return array;
    }

}