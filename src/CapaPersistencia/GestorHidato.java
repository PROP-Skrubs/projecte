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
    private static final Connection conn = CapaPersistencia.conn;
    private static final String COUNT_HIDATO = "SELECT COUNT(*) FROM hidatos WHERE idHidato = ?";
    private static final String INSERT_HIDATO = "INSERT INTO hidatos (" +
            "idTauler," +
            "idTaulerComplert," +
            "dificultat" +
            ") VALUES (?,?,?)";
    private final static String DELETE_HIDATO = "DELETE FROM hidatos WHERE id = ?";
    private final static String SELECT_HIDATO= "SELECT * FROM hidatos WHERE id = ?";
    private static Integer idTaulerIni;
    private static Integer idTaulerFi;
    private static Integer idhidato;

    public static boolean existeixHidato(int id)
    {
        try (PreparedStatement s = conn.prepareStatement(COUNT_HIDATO))
        {
            s.setInt(1,id);
            ResultSet resSet = s.executeQuery();
            resSet.next();
            if (resSet.getInt(1) >= 2) throw new RuntimeException("Dos Hidatos a la Base de Dades amb la mateixa ID!!");
            return resSet.getInt(1) == 1;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Hidato donaHidato(int id)
    {
        Hidato aRetornar = null;
        try (PreparedStatement p = conn.prepareStatement(SELECT_HIDATO))
        {
            p.setInt(1,id);
            ResultSet resSet = p.executeQuery();
            if (resSet.next())
            {
                aRetornar = new Hidato();
                aRetornar.setUniqID(id);
                int idTauler = resSet.getInt("idTauler");
                aRetornar.setTauler(GestorTauler.donaTauler(idTauler));
                int idTaulerComplert = resSet.getInt("idTaulerComplert");
                aRetornar.setTaulerComplert(GestorTauler.donaTaulerComplert(idTaulerComplert));
                aRetornar.setDificultat(resSet.getString("dificultat"));
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return aRetornar;
    }


    public static boolean crearHidato(Hidato h) {
        if (existeixHidato(h.getUniqID()))
            return false;
        try (PreparedStatement p = CapaPersistencia.conn.prepareStatement(INSERT_HIDATO)) {
            p.setInt(1, h.);
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
                    h.setUniqID(id);
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
                    h.setUniqID(idh);
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
