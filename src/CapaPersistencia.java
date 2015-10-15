import java.sql.*;

/**
 * Created by daniel on 13/10/15.
 */

public class CapaPersistencia
{
    private static Connection conn;

    static
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:sqlite:basedades.db");
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
            throw new RuntimeException("No s'ha pogut connectar a la Base de Dades!");
        }
        validarBaseDeDades();
    }

    public static boolean crearUsuari(Usuari u)
    {
        try (Statement s = conn.createStatement();
             ResultSet resSet = s.executeQuery("SELECT COUNT(*) FROM usuaris WHERE nomUsuari = '" + u.getNomUsuari() + "'"))
        {
            resSet.next();
            if (resSet.getInt(1) != 0) return false; //Aixo vol dir que ja hi ha un usuari amb aquest nom a la BD
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        //Ja hem comprovat que no hi ha un usuari amb el mateix nom... per tant podem inserir be.
        try (PreparedStatement p = conn.prepareStatement("INSERT INTO usuaris (nomUsuari, contrasenya, nomReal) VALUES (?,?,?)"))
        {
            p.setString(1, u.getNomUsuari());
            p.setString(2, u.getContrasenya());
            p.setString(3, u.getNomReal());
            p.executeUpdate();
            return true;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static boolean eliminarUsuari(String nomUsuari)
    {
        //Per anar be, aquesta funcio nomes l'hauria de poder arribar a cridar l'administrador!!!
        // o potser tambe el usuari per a si mateix (?)
        try (Statement s = conn.createStatement())
        {
            int usuarisBorrats = s.executeUpdate("DELETE FROM usuaris WHERE nomUsuari = '" + nomUsuari + "'");
            if (usuarisBorrats != 1)
            {
                String problema;
                if (usuarisBorrats == 0) return false;
                else problema = String.format("S'han borrat %d usuaris!", usuarisBorrats);
                throw new RuntimeException(problema);
                /*TODO:
                    Si no s'ha borrat cap usuari, es pot avisar a l'usuari en lloc de morir.
                      ^aixo ja esta fet a base de que retorni un boolea
                    Si s'han borrat _multiples_ usuaris, llavors toca morir bastant... wtf.
                      ^fet tirant una RuntimeException
                 */
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
        try (Statement s = conn.createStatement();
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

    private static void validarBaseDeDades()
    {
        //Executem tots els CREATE TABLE statements per assegurar-nos que la BD esta en condicions d'operar. Exemple:
        /*  'CREATE TABLE IF NOT EXISTS table_name (
            {table definition...}
            )'
        */
        String usuarisCreateTable = "CREATE TABLE IF NOT EXISTS usuaris (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomUsuari VARCHAR(30) NOT NULL UNIQUE," +
                "contrasenya VARCHAR(30) NOT NULL," +
                "nomReal VARCHAR(30)" +
                ")";
        //Falta afegir el codi de la resta de taules
        try (Statement statement = conn.createStatement())
        {
            statement.execute(usuarisCreateTable);
            //Falta afegir el codi de la resta de taules
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}


