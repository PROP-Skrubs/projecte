/**
 * Created by daniel on 13/10/15.
 */
public class CapaPersistencia
{
    public static Usuari donaUsuari(String nomUsuari)
    {
        if (true /*usuari a la BD*/)
        {
            Usuari u = new Usuari();
            u.setNomUsuari(nomUsuari);
            return u;
        }
        else
        {
            return null;
        }
    }
}
