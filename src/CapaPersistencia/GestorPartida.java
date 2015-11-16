package CapaPersistencia;

import CapaDomini.Casella;
import CapaDomini.Partida;
import CapaDomini.Usuari;

import java.sql.*;

/**
 * Created by Maria on 15/11/2015.
 */
public class GestorPartida
{
    private static final Connection conn = CapaPersistencia.conn;

    private static final String INSERT_PARTIDA = "INSERT INTO partides (" +
            "    idUsuari," +
            "    idHidato," +
            "    idTaulerProgres," +
            "    nCelesResoltes," +
            "    numAjudesUtilitzades," +
            "    esAcabada" +
            "    ) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String COUNT_PARTIDA = "SELECT COUNT(*) FROM partides WHERE id=?";
    private static final String DELETE_PARTIDA = "DELETE FROM partides WHERE id=?";
    private static final String SELECT_PARTIDA = "SELECT * FROM partides WHERE id=?";
    private static final String UPDATE_PARTIDA = "UPDATE partides SET" +
            "    idUsuari=?," +
            "    idHidato=?," +
            "    idTaulerProgres=?," +
            "    nCelesResoltes=?," +
            "    numAjudesUtilitzades=?," +
            "    esAcabada=?" +
            "WHERE id=?";

    public static boolean existeixPartida(int id)
    {
        if (id == -1)
            return false;
        try (PreparedStatement s = conn.prepareStatement(COUNT_PARTIDA))
        {
            s.setInt(1, id);
            ResultSet resSet = s.executeQuery();
            resSet.next();
            if (resSet.getInt(1) >= 2)
                throw new RuntimeException("Dos Partides a la Base de Dades amb la mateixa ID!!");
            return resSet.getInt(1) == 1;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Partida donaPartida(int id)
    {
        Partida aRetornar;
        try (PreparedStatement p = conn.prepareStatement(SELECT_PARTIDA))
        {
            p.setInt(1, id);
            ResultSet resSet = p.executeQuery();
            if (resSet.next())
            {
                aRetornar = new Partida();
                aRetornar.setUniqID(resSet.getInt("id"));
                Usuari u = GestorUsuari.donaUsuari(resSet.getInt("idUsuari"));
                aRetornar.setUsu
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return aRetornar;
    }

    public static int creaPartida(Partida p)
    {
        if (GestorHidato.existeixHidato(p.getIdHidato()))
            GestorHidato.creaHidato(p.getHidato());


    }

    public static boolean eliminaPartida(int id)
    {

    }

    public static boolean modificaPartida(Partida p)
    {

    }


    public static boolean crearPartida(Partida p)
    {
        //Miramos si ya hay algun partida con p.partida
        try (Statement s = CapaPersistencia.conn.createStatement();
             ResultSet resSet = s.executeQuery("SELECT COUNT(*) FROM partida WHERE idpartida = '" + (p.getUniqID()) + "'"))
        {
            resSet.next();
            if (resSet.getInt(1) != 0) return false;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        try (PreparedStatement insert = CapaPersistencia.conn.prepareStatement("INSERT INTO partida (idpartida, idhidato, iduser, ncelesresolt, numajud, matriz, acabat)  VALUES (?,?,?,?,?,?,?)"))
        {
            insert.setInt(1, p.getUniqID());
            insert.setInt(2, p.getIdHidato());
            insert.setInt(3, p.getIdUser());
            insert.setInt(4, p.getnCelesResoltes());
            insert.setInt(5, p.getNumAjudesUtilitzades());
            String s = fromCasellaToString(p.getMatriu(), p.getMatriu().length);
            insert.setString(6, s);
            insert.setBoolean(7, p.esAcabada());
            insert.executeUpdate();
            return true;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static boolean eliminarPartida(Integer idpartida)
    {
        try (Statement s = CapaPersistencia.conn.createStatement())
        {
            int partidesborrades = s.executeUpdate("DELETE FROM partida WHERE idpartida = '" + idpartida + "'");
            if (partidesborrades != 1)
            {
                String problema;
                if (partidesborrades == 0) return false;
                else problema = String.format("S'han borrat %d partidas!", partidesborrades);
                throw new RuntimeException(problema);
            }
            return true;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Partida getPartida(Integer idp)
    {
        Partida p = new Partida();
        String sDriverName = "org.sqlite.JDBC";
        try
        {
            Class.forName(sDriverName);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Maria/ProgramaJava/projecte_Skrubs/basedades.db"))
        {
            PreparedStatement consulta = c.prepareStatement("SELECT * FROM partida WHERE idpartida =  '" + idp + "'");
            try (ResultSet rs = consulta.executeQuery())
            {
                while (rs.next())
                {
                    Integer idpartida = rs.getInt("idpartida");
                    Integer idhidato = rs.getInt("idhidato");
                    Integer iduser = rs.getInt("iduser");
                    Integer ncelesresolt = rs.getInt("ncelesresolt");
                    Integer numajud = rs.getInt("numajud");
                    String matriu = rs.getString("matriz");
                    Boolean acabat = rs.getBoolean("acabat");
                    p.setUniqID(idpartida);
                    p.setIdHidato(idhidato);
                    p.setIdUser(iduser);
                    p.setnCelesResoltes(ncelesresolt);
                    p.setNumAjudesUtilitzades(numajud);
                    //fer consulta per trobar el tamany que s'ha de pasar
                    // Casella[][] caux = fromStringToCasella(matriu,);
                    // p.setMatriu(caux);
                    p.setEsAcabada(acabat);
                }
                return p;
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return p;
    }

    public static Casella[][] fromStringToCasella(String vec, int tamany)
    {
        Casella[][] c = new Casella[tamany][tamany];
        String[] aux = vec.split(",");
        for (int i = 0; i < tamany; ++i)
        {
            for (int j = 0; j < tamany; ++j)
            {
                c[i][j] = new Casella(i, j, Integer.parseInt(aux[i * tamany + j]));
            }
        }
        return c;
    }

    public static String fromCasellaToString(Casella[][] matriz, int tamany)
    {
        String s = new String();
        for (int i = 0; i < tamany; ++i)
        {
            for (int j = 0; j < tamany; ++j)
            {
                s += String.valueOf(matriz[i][j].getElem()) + ',';
            }
        }
        //quito la ultima coma con el substring
        return s.substring(0, s.length() - 1);
    }
}
