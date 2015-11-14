package CapaPersistencia;

import CapaDomini.Casella;
import CapaDomini.Tauler;
import CapaDomini.TaulerComplert;

import java.sql.*;

/**
 * Created by Maria on 14/11/2015.
 */
public class TaulerOmplertCP {
    public static boolean crearTauleromplert(TaulerComplert tomp) {
        //Miramos si ya hay algun taulerini con idtaulerini
        try (Statement s = CapaPersistencia.conn.createStatement();
             ResultSet resSet = s.executeQuery("SELECT COUNT(*) FROM tauler_omplert WHERE id_tauleromplert = '" + (tomp.getIdtauler()) + "'")) {
            resSet.next();
            if (resSet.getInt(1) != 0) return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (PreparedStatement p = CapaPersistencia.conn.prepareStatement("INSERT INTO tauler_omplert (id_tauleromplert, medida, matriz)  VALUES (?,?,?)")) {
            p.setInt(1, tomp.getIdtauler());
            p.setInt(2, tomp.tamany());
            String m = fromCasellaToString(tomp.getTauler(),tomp.tamany());
            p.setString(3, m);
            p.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean eliminartaulerini(Integer idtauleromp) {
        try (Statement s = CapaPersistencia.conn.createStatement()) {
            int tauler_borrat = s.executeUpdate("DELETE FROM tauler_omplert WHERE id_tauleromplert = '" + idtauleromp + "'");
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

    public static TaulerComplert getTaulerOmp(Integer idomp) {
        TaulerComplert ini = new TaulerComplert();
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/ProgramaJava/projecte_Skrubs/basedades.db")) {
            PreparedStatement consulta = c.prepareStatement("SELECT * FROM tauler_omplert WHERE id_tauleromplert  = '" + idomp + "'");
            try (ResultSet rs = consulta.executeQuery()) {
                while (rs.next()) {
                    Integer idtaulerinia = rs.getInt("id_tauleromplert");
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
