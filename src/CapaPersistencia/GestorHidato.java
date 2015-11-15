package CapaPersistencia;

import CapaDomini.Hidato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria on 07/11/2015.
 */
public class GestorHidato
{
    //checkhidato
    private static Integer idTaulerIni;
    private static Integer idTaulerFi;
    private static Integer idhidato;

    public static void donaIDHidato(){
            try (PreparedStatement p = CapaPersistencia.conn.prepareStatement("SELECT idhidato FROM hidato ORDER BY idhidato")) {
                ResultSet rs = p.executeQuery();
                idhidato = rs.getInt("idhidato");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void donaIDTaulerIni(){
        try (PreparedStatement p = CapaPersistencia.conn.prepareStatement("SELECT id_taulerini FROM tauler_ini ORDER BY id_taulerini")) {
            ResultSet rs = p.executeQuery();
            idTaulerIni = rs.getInt("id_taulerini");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void donaTaulerOmplert(){
        try (PreparedStatement p = CapaPersistencia.conn.prepareStatement("SELECT id_tauleromplert FROM tauler_omplert ORDER BY id_tauleromplert")) {
            ResultSet rs = p.executeQuery();
            idTaulerFi = rs.getInt("id_tauleromplert");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean crearHidato(Hidato h) {
        //Miramos si ya hay algun hidato con h.idhidato
        try (Statement s = CapaPersistencia.conn.createStatement();
             ResultSet resSet = s.executeQuery("SELECT COUNT(*) FROM hidato WHERE idhidato = '" + (h.getIdhidato()) + "'")) {
            resSet.next();
            if (resSet.getInt(1) != 0) return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (PreparedStatement p = CapaPersistencia.conn.prepareStatement("INSERT INTO hidato (idhidato,id_taulerini,id_tauleromplert, dificultad) VALUES (?,?,?,?)")) {
            donaIDHidato();
            donaIDTaulerIni();
            donaTaulerOmplert();
            p.setInt(1, idhidato);
            p.setInt(2, idTaulerIni);
            p.setInt(3, idTaulerFi);
            p.setString(4, h.isDificultat());
            p.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean eliminarHidato(Integer idhidato) {
        try (Statement s = CapaPersistencia.conn.createStatement()) {
            int hidatosborrats = s.executeUpdate("DELETE FROM hidato WHERE id = '" + idhidato + "'");
            if (hidatosborrats != 1) {
                String problema;
                if (hidatosborrats == 0) return false;
                else problema = String.format("S'han borrat %d hidatos!", hidatosborrats);
                throw new RuntimeException(problema);
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }"idhidato"

    public static List<Hidato> getHidatos() {
        List<Hidato> lista = new ArrayList<>();
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/ProgramaJava/projecte_Skrubs/basedades.db")) {
            PreparedStatement consulta = c.prepareStatement("SELECT * FROM hidato ORDER BY idhidato");
            try (ResultSet rs = consulta.executeQuery()) {
                while (rs.next()) {
                    Integer id = rs.getInt("idhidato");
                    Integer idtaulerinia = rs.getInt("id_taulerini");
                     Integer idtauleromplerta = rs.getInt("id_tauleromplert");
                    String dif = rs.getString("dificultad");
                    Hidato h = new Hidato();
                    h.setIdhidato(id);
                    h.setDificultat(dif);
                   // h.setTauler(null);
                   // h.setTaulerComplert(null);
                    lista.add(h);
                }
                return lista;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
      public static Hidato getHidato(Integer idhidato) {
        Hidato h = new Hidato();
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/ProgramaJava/projecte_Skrubs/basedades.db")) {
            PreparedStatement consulta = c.prepareStatement("SELECT * FROM hidato WHERE idhidato  = '" + idhidato + "'");
            try (ResultSet rs = consulta.executeQuery()) {
                while (rs.next()) {
                    Integer idh = rs.getInt("idhidato");
                    Integer idtiini = rs.getInt("id_taulerini");
                    Integer idtomp = rs.getInt("id_tauleromplert");
                    String dificultad  = rs.getString("dificultad");
                    h.setIdhidato(idh);
                    h.setDificultat(dificultad);
                    TauleriniCP.getTaulerini(idtiini);
                    TaulerOmplertCP.getTaulerOmp(idtomp);
                    h.setTauler(TauleriniCP.getTaulerini(idtiini));
                    h.setTaulerComplert(TaulerOmplertCP.getTaulerOmp(idtomp));
                }
                return h;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return h;
    }
}
