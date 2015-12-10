package CapaPersistencia;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by oriol on 7/12/15.
 */
public class GestorRanking {
    private final static Connection conn = CapaPersistencia.conn;
    private final static String SELECT_USUARIS_PER_HIDATO = "SELECT idUsuari FROM estadistica WHERE idHidato = ? ORDER BY temps LIMIT=10";
    private final static String SELECT_HIDATOS_PER_COPS_RESOLT = "SELECT idHidato FROM estadistica ORDER BY copsResolt LIMIT=10";
    private final static String SELECT_PERSONES_PER_DIFICULTAT = "SELECT  idUsuari FROM estadistica WHERE idHidato = ? ";
    private final static String SELECT_HIDATOS_AMB_DIFICULTAT = "SELECT id FROM hidatos WHERE dificultat = ?";

    public static ArrayList<Integer> getIdUsuarisPerHidato (int idHidato){
        ArrayList<Integer> array = new ArrayList<Integer>();
        try (PreparedStatement s = conn.prepareStatement(SELECT_USUARIS_PER_HIDATO))
        {
            s.setInt(1, idHidato);
            ResultSet resSet = s.executeQuery();
            while (resSet.next()) {
                int i = resSet.getInt("idUsuari");
                array.add(i);
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return array;
    }

    public static ArrayList<Integer> getIdHidatosMesCopsResolts (int idHidato){
        ArrayList<Integer> array = new ArrayList<Integer>();
        try (PreparedStatement s = conn.prepareStatement(SELECT_HIDATOS_PER_COPS_RESOLT))
        {
            ResultSet resSet = s.executeQuery();
            while (resSet.next()) {
                int i = resSet.getInt("idHidato");
                array.add(i);
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return array;
    }

    public static ArrayList<Integer> getIdHidatosPerDificultat (String dificultat){
        ArrayList<Integer> array = new ArrayList<Integer>();
        try (PreparedStatement s = conn.prepareStatement(SELECT_HIDATOS_AMB_DIFICULTAT))
        {
            s.setString(1, dificultat);
            ResultSet resSet = s.executeQuery();
            while (resSet.next()) {
                int i = resSet.getInt("idHidato");
                array.add(i);
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return array;
    }

    public ArrayList<Integer> ordenaUsuaris (ArrayList<Integer> ids, ArrayList<Integer> temps){
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 1; i < ids.size(); ++i){
            int idtemp = ids.get(i);
            int aux = temps.get(i);
            int j;
            for (j =  i -1; j >=0  && aux < temps.get(j); j--) {
                ids.set(j+1, ids.get(j));
                temps.set(j + 1, temps.get(j));
            }
            ids.set(j+1, idtemp);
            temps.set(j+1, aux);
        }
        return ids;
    }

    public ArrayList<Integer> getIdUsuarisPerDificultat(ArrayList<Integer> ids){

        ArrayList<Integer> arrayids = new ArrayList<Integer>();
        ArrayList<Integer> arraytemp = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        try (PreparedStatement s = conn.prepareStatement(SELECT_PERSONES_PER_DIFICULTAT))
        {
            for(int i = 0 ; i < ids.size(); ++i) {
                s.setInt(1, ids.get(i));
                ResultSet resSet = s.executeQuery();
                while (resSet.next()) {
                    int id = resSet.getInt("idUsuari");
                    arrayids.add(id);
                    int t = resSet.getInt("temps");
                    arraytemp.add(t);
                }
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        result = ordenaUsuaris(arrayids, arraytemp);
        result.subList(0,9);
        return result;
    }
}
