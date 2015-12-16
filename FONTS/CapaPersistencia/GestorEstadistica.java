package CapaPersistencia;

import CapaDomini.Modelo.EstadisticasUsuari;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria on 25/11/2015.
 */
public class GestorEstadistica {
    private static final Connection conn = CapaPersistencia.conn;
    private static final String INSERT_EST = "INSERT INTO estadistica (idUsuari,idHidato,nIntents,copsResolt,temps,nAjudes) VALUES (?,?,?,?,?,?)";
    private final static String SELECT_ESTADISTICA = "SELECT * FROM estadistica WHERE idUsuari = ? and idHidato = ?";
    private final static String DELETE_ESTADISTICA = "DELETE FROM estadistica WHERE idUsuari = ? and idHidato = ?";
    private final static String UPDATE_ESTADISTICA = "UPDATE estadistica SET" +
            "    nIntents=?," +
            "    copsResolt=?," +
            "    temps=?," +
            "    nAjudes=? WHERE idUsuari=? and idHidato=?";

   // "nAjudes=? WHERE id=?";

    private final static String SELECT_ALL_ESTADISTICA = "SELECT * FROM estadistica WHERE idUsuari = ?";
    private final static String SELECT_TEMPS = "SELECT temps FROM estadistica WHERE idHidato = ?";
    private final static String SELECT_NINTENTS = "SELECT nIntents FROM estadistica WHERE idHidato = ?";
    private final static String SELECT_COPSRESOLT = "SELECT copsResolt FROM estadistica WHERE idHidato = ?";
    private final static String SELECT_NAJUDES = "SELECT nAjudes FROM estadistica WHERE idHidato = ?";
    private final static String SELECT_ALL_ID = "SELECT DISTINCT idHidato FROM estadistica";
    private final static String SELECT_DIFICULTAD = "SELECT dificultat FROM hidatos WHERE id = ?";
    private static final String COUNT_ESTADISTICA = "SELECT COUNT(*) FROM estadistica WHERE idUsuari=? and idHidato=?";
    private static final String COUNT_USUARI_EST = "SELECT COUNT(*) FROM estadistica WHERE idUsuari=?";
    private final static String SELECT_ALL_ID_DIF = "SELECT DISTINCT id FROM hidatos WHERE dificultat = ?";



    /**
     * Aquesta funcio mira si ja existeix una Estadistica amb la idHidato i idUsuari pasada per parametre a la BD
     * @param idHidato
     * @param idUsuari
     * @return Retorna true si existeix una Estadistica amb aquella idUsuari i idHidato a la BD
     */
    public static boolean existeixEstadistica(int idHidato, int idUsuari){
        if(idHidato == -1 || idUsuari == -1) return false;
        try (PreparedStatement s = conn.prepareStatement(COUNT_ESTADISTICA))
        {
            s.setInt(1, idUsuari);
            s.setInt(2, idHidato);
            ResultSet resSet = s.executeQuery();
            resSet.next();
                if (resSet.getInt(1) >= 2) throw new RuntimeException("Dos estadistiques a la Base de Dades amb els mateixos IDUsuari i idHidato!!");
            return resSet.getInt(1) == 1;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Aquesta funcio mira si ja existeix una Estadistica amb l'idUsuari passat per parametre a la BD
     * @param idUsuari
     * @return Retorna true si existeix alguna Estadistica d'aquell idUsuari a la BD
     */
    public static boolean existeixUsuariEnEstadistica(int idUsuari){
        try (PreparedStatement s = conn.prepareStatement(COUNT_USUARI_EST))
        {
            s.setInt(1, idUsuari);
            ResultSet resSet = s.executeQuery();
            resSet.next();
            if (resSet.getInt(1) >= 0) return true;
            else return false;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Aquesta funcio guarda l'EstadisticaUsuari passada per parametre a la BD
     * @param est
     * @return Retorna true si es guarda correctament i false en cas que ja existeixi
     */
    public static boolean guardaEstadistica(EstadisticasUsuari est) {
        if (existeixEstadistica(est.getIdUsuari(),est.getIdHidato()))
            return false;
        try (PreparedStatement ps = conn.prepareStatement(INSERT_EST)) {
            ps.setInt(1, est.getIdUsuari());
            ps.setInt(2, est.getIdHidato());
            ps.setInt(3, est.getIntents());
            ps.setInt(4, est.getCops_res());
            ps.setInt(5, est.getTemps_mig());
            ps.setInt(6, est.getAjudes());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    /**
     * Aquesta funcio dona totes les Estadistiques de l'usuari iduser  passat per parametre a la BD
     * @param iduser
     * @return Retorna una llista amb totes les estadistiques de l'usuari iduser
     */
    public static List<EstadisticasUsuari> dona_estadistiques_Usuari(int iduser) {
        List<EstadisticasUsuari> l = new ArrayList<>();

        try (PreparedStatement p = conn.prepareStatement(SELECT_ALL_ESTADISTICA)) {
            p.setInt(1, iduser);
            ResultSet resSet = p.executeQuery();
            while (resSet.next()) {
                EstadisticasUsuari aRetornar = new EstadisticasUsuari();
                aRetornar.setIdUsuari(resSet.getInt("idUsuari"));
                aRetornar.setIdHidato(resSet.getInt("idHidato"));
                aRetornar.setIntents(resSet.getInt("nIntents"));
                aRetornar.setCops_res(resSet.getInt("copsResolt"));
                aRetornar.setTemps_mig(resSet.getInt("temps"));
                aRetornar.setAjudes(resSet.getInt("nAjudes"));
                l.add(aRetornar);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    /**
     * Aquesta funcio dona una llista amb tots els temps de les estadistiques
     * d'idhidato passat per parametre a la BD
     * @param idhidato
     * @return Retorna una llista amb el temps de les estadistiques d'idhidato
     */
    public static List<Integer> get_temps(int idhidato) {
        List<Integer> l = new ArrayList<>();
        try (PreparedStatement p = conn.prepareStatement(SELECT_TEMPS)) {
            p.setInt(1, idhidato);
            ResultSet resSet = p.executeQuery();
            while (resSet.next()) {
                l.add(resSet.getInt("temps"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    /**
     * Aquesta funcio dona el numero d'intents de totes les Estadistiques
     * de idhidato passat per parametre a la BD
     * @param idhidato
     * @return Retorna una llista amb els nintents de les estadistiques de idhidato
     */
    public static List<Integer> get_nintents(int idhidato) {
        List<Integer> l = new ArrayList<>();
        try (PreparedStatement p = conn.prepareStatement(SELECT_NINTENTS)) {
            p.setInt(1, idhidato);
            ResultSet resSet = p.executeQuery();
            while (resSet.next()) {
                l.add(resSet.getInt("nIntents"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    /**
     * Aquesta funcio dona el numero de coprs resolt de totes les Estadistiques
     * de idhidato passat per parametre a la BD
     * @param idhidato
     * @return Retorna una llista amb el numero de cops resolt de les estadistiques de idhidato
     */
    public static List<Integer> get_copsResolt(int idhidato) {
        List<Integer> l = new ArrayList<>();
        try (PreparedStatement p = conn.prepareStatement(SELECT_COPSRESOLT)) {
            p.setInt(1, idhidato);
            ResultSet resSet = p.executeQuery();
            while (resSet.next()) {
                l.add(resSet.getInt("copsResolt"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    /**
     * Aquesta funcio dona el numero d'ajudes de totes les Estadistiques
     * de idhidato passat per parametre a la BD
     * @param idhidato
     * @return Retorna una llista amb el numero d'ajudes resolt de les estadistiques de idhidato
     */
    public static List<Integer> get_nAjudes(int idhidato) {
        List<Integer> l = new ArrayList<>();
        try (PreparedStatement p = conn.prepareStatement(SELECT_NAJUDES)) {
            p.setInt(1, idhidato);
            ResultSet resSet = p.executeQuery();
            while (resSet.next()) {
                l.add(resSet.getInt("nAjudes"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    /**
     * Aquesta funcio dona una llista amb tots els idhidatos que hi ha a les Estadistiques
     * @return Retorna una llista amb els idhidatos de estadistiques
     */
    public static List<Integer> get_idHidatos( ) {
        List<Integer> l = new ArrayList<>();
        try (PreparedStatement p = conn.prepareStatement(SELECT_ALL_ID)) {
            ResultSet resSet = p.executeQuery();
            while (resSet.next()) {
                l.add(resSet.getInt("idHidato"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    /**
     * Aquesta funcio dona els idHidato que tenen la dificultat passada per parametre
     * @param dificultat
     * @return Retorna una llista amb els idHidato que tenen la dificultat "dificultat"
     */
    public static List<Integer> get_Hidatos_dificultat_x(String dificultat ) {
        List<Integer> l = new ArrayList<>();
        try (PreparedStatement p = conn.prepareStatement(SELECT_ALL_ID_DIF)) {
            p.setString(1, dificultat);
            ResultSet resSet = p.executeQuery();
            while (resSet.next()) {
                l.add(resSet.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    /**
     * Aquesta funcio dona la dificultat de idHidato
     * @param idHidato
     * @return Retorna la dificultat de idHidato
     */
    public static String get_dificultat(Integer idHidato) {
        String res = null;
        try (PreparedStatement p = conn.prepareStatement(SELECT_DIFICULTAD)) {
            p.setInt(1, idHidato);
            ResultSet resSet = p.executeQuery();
            res = resSet.getString("dificultat");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    /**
     * Aquesta funcio dona l'estadistica que te iduser i id_Hidato de la BD
     * @param iduser
     * @param id_Hidato
     * @return Retorna una Estadistica que te com a parametres isuser i id_Hidato
     */
    public static EstadisticasUsuari donaEstadistica(int iduser, int id_Hidato) {
        EstadisticasUsuari aRetornar = null;
        try (PreparedStatement p = conn.prepareStatement(SELECT_ESTADISTICA)) {
            p.setInt(1, iduser);
            p.setInt(2, id_Hidato);
            ResultSet resSet = p.executeQuery();
            if (resSet.next()) {
                aRetornar = new EstadisticasUsuari();
                aRetornar.setIdUsuari(resSet.getInt("idUsuari"));
                aRetornar.setIdHidato(resSet.getInt("idHidato"));
                aRetornar.setIntents(resSet.getInt("nIntents"));
                aRetornar.setCops_res(resSet.getInt("copsResolt"));
                aRetornar.setTemps_mig(resSet.getInt("temps"));
                aRetornar.setAjudes(resSet.getInt("nAjudes"));
            }
            if (resSet.next()) //Hi ha mes d'una estadistica que concorda amb la idUsuari i idHidato donats! Error!!!
            {
                throw new RuntimeException("Hi ha mes d'una estadistica amb el mateix idUsuari i idHidato!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aRetornar;
    }

    /**
     * Aquesta funcio elimina de la BD l'estadistica amb iduser i idHidato
     * @param iduser
     * @param idHidato
     * @return Retorna true si s'ha esborrat correctament, i false en cas contrari
     */
    public static boolean eliminaEstadistica(int iduser, int idHidato) {
        Boolean b = true;
        String problema = null;
        try (PreparedStatement s = conn.prepareStatement(DELETE_ESTADISTICA)) {
            s.setInt(1, iduser);
            s.setInt(2, idHidato);
            int estBorrades = s.executeUpdate();
            if (estBorrades != 1) {
                if (estBorrades == 0) b= false;
                else problema = String.format("S'han borrat %d Estadistiques Usuari!", estBorrades);
                throw new RuntimeException(problema);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    /**
     * Aquesta funcio modifica a la BD l'estadistica est passada per parametre
     * @param est
     * @return Retorna true si s'ha modificat i false en cas contrari
     */
    public static boolean modificaEstadistica(EstadisticasUsuari est){
        boolean b = false;
        if(!existeixEstadistica(est.getIdUsuari(),est.getIdHidato())){
            b = false;
        }
        try (PreparedStatement s = conn.prepareStatement(UPDATE_ESTADISTICA)){
            s.setInt(1,est.getIntents());
            s.setInt(2, est.getCops_res());
            s.setInt(3,est.getTemps_mig());
            s.setInt(4,est.getAjudes());
            s.setInt(5,est.getIdUsuari());
            s.setInt(6,est.getIdHidato());
            int modificats = s.executeUpdate();
            if (modificats != 1)
            {
                String problema;
                if (modificats == 0)
                    throw new RuntimeException("No s'ha modificat l'estadistica, pero ha passat el check d'existencia.");
                else problema = String.format("S'han modificat %d estadistiques!", modificats);
                throw new RuntimeException(problema);
            }
            b = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

}
