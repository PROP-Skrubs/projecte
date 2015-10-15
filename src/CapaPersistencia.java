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
        } catch (SQLException e)
        {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        validarBaseDeDades();
    }

    public static void crearUsuari(Usuari u)
    {
        try
        {
            Statement s = conn.createStatement();
            String query = "INSERT INTO usuaris (nomUsuari, contrasenya, nomReal) VALUES (" +
                    "'"+ u.getNomUsuari() +"',"+
                    "'"+ u.getContrasenya() +"',"+
                    "'"+ u.getNomReal() +"'"+
                    ")";
            System.out.println(query);
            s.execute(query);
            //TODO: Falta implementar tirar excepcions si l'usuari ja existeix
        } catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static void eliminarUsuari(String nomUsuari)
    {
        //Per anar be, aquesta funcio nomes l'hauria de poder arribar a cridar l'administrador!!!
        try
        {
            Statement s = conn.createStatement();
            s.executeQuery("DELETE FROM usuaris WHERE nomUsuari = '" + nomUsuari + "'");
            //TODO: Falta implementar tirar excepcions si l'usuari NO existia
        } catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static Usuari donaUsuari(String nomUsuari)
    {
        Usuari u = null;
        try
        {
            Statement s = conn.createStatement();
            ResultSet resSet = s.executeQuery("SELECT * FROM usuaris u WHERE u.nomUsuari = '" + nomUsuari + "'");
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
                //TODO: aprendre excepcions i fer-es servir
                //throw excepcio.
                System.err.println("Error meds un user");
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        return u;
    }

    private static void validarBaseDeDades()
    {
        //Executem tots els CREATE TABLE statements per assegurar-nos que la BD esta en condicions d'operar. Exemple:
        /*  'CREATE TABLE IF NOT EXISTS queue '
            '('
            '  id INTEGER PRIMARY KEY AUTOINCREMENT,'
            '  item BLOB'
            ')'
        */

        try
        {
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS usuaris (" +
                            "id UNIQUEIDENTIFIER," +
                            "nomUsuari VARCHAR(30)," +
                            "contrasenya VARCHAR(30)," +
                            "nomReal VARCHAR(30)" +
                            ")"
            );

            //Falta afegir el codi de la resta de taules
        } catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}


/*
CREATE TABLE IF NOT EXISTS usuaris (
id UNIQUEIDENTIFIER,
nomUsuari VARCHAR(30),
contrasenya VARCHAR(30),
nomReal VARCHAR(30),
);
 */