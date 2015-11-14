package CapaPersistencia;

import CapaDomini.Casella;
import CapaDomini.Hidato;
import CapaDomini.Tauler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria on 01/11/2015.
 */
public class TauleriniCP {

    public static boolean crearTaulerini(Tauler tini) {
        //Miramos si ya hay algun taulerini con idtaulerini
        try (Statement s = CapaPersistencia.conn.createStatement();
             ResultSet resSet = s.executeQuery("SELECT COUNT(*) FROM tauler_ini WHERE id_taulerini = '" + (tini.getIdtauler()) + "'")) {
            resSet.next();
            if (resSet.getInt(1) != 0) return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (PreparedStatement p = CapaPersistencia.conn.prepareStatement("INSERT INTO tauler_ini (id_taulerini,medida, matriz)  VALUES (?,?,?)")) {
            p.setInt(1, tini.getIdtauler());
            p.setInt(2, tini.tamany());
            String m = fromCasellaToString(tini.getTauler(),tini.tamany());
            p.setString(3, m);
            p.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean eliminartaulerini(Integer idtaulerini) {
        try (Statement s = CapaPersistencia.conn.createStatement()) {
            int tauler_borrat = s.executeUpdate("DELETE FROM tauler_ini WHERE id_taulerini = '" + idtaulerini + "'");
            if (tauler_borrat != 1) {
                String problema;
                if (tauler_borrat == 0) return false;
                else problema = String.format("S'han borrat %d tauler_ini!", tauler_borrat);
                throw new RuntimeException(problema);
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Tauler getTaulerini(Integer idtaulerini) {
        Tauler ini = new Tauler();
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/ProgramaJava/projecte_Skrubs/basedades.db")) {
            PreparedStatement consulta = c.prepareStatement("SELECT * FROM tauler_ini WHERE id_taulerini  = '" + idtaulerini + "'");
            try (ResultSet rs = consulta.executeQuery()) {
                while (rs.next()) {
                    Integer idtaulerinia = rs.getInt("id_taulerini");
                    Integer medida = rs.getInt("medida");
                    String matriz = rs.getString("matriz");
                    ini.setIdtauler(idtaulerinia);
                    Casella[][] caux = fromStringToCasella(matriz,medida);
                    ini.setTauler(caux);
                }
                return ini;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ini;
    }

    public static Casella[][] fromStringToCasella(String vec, Integer medida) {
        String[] aux = vec.split(",");
        Casella[][] c = new Casella[medida][medida];
        for(int i=0; i<medida;++i) {
            for(int j =0; j<medida;++j) {
                Integer m = Integer.parseInt(aux[i * medida + j]);
                Casella auxm = new Casella(i, j, m);
                c[i][j] = auxm;
            }
        }
        return c;
    }

    public static String fromCasellaToString(Casella[][] matriz, int tamany){
        String s = new String();
        for(int i =0; i<tamany;++i) {
            for(int j =0; j<tamany;++j) {
                s += String.valueOf(matriz[i][j].getElem()) + ',';
            }
        }
        //quito la ultima coma con el substring
        return  s.substring(0,s.length()-1);
    }
}

