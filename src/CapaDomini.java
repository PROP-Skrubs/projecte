/**
 * Created by daniel on 12/10/15.
 */
public class CapaDomini
{
    private static Usuari usuariActual;

    public static boolean fesLogin(String nomUsuari, String contrasenya)
    {
        Usuari u = CapaPersistencia.donaUsuari(nomUsuari);
        if (u == null) return false;
        if (!u.validaContrasenya(contrasenya)) return false;

        //si passa totes les comprovacions
        usuariActual = u;
        return true;
    }

    public static boolean crearUsuari(String nomUsuari, String contrasenya, String nomReal)
    {
        Usuari u = new Usuari();
        u.setNomUsuari(nomUsuari);
        u.setContrasenya(contrasenya);
        u.setNomReal(nomReal);
        return CapaPersistencia.crearUsuari(u);
        /*TODO:
            Controlar les excepcions i el resultat de la operacio.
              ^en principi ja es controla tot lo necessari (basicament si es crea o no l'user) i es deixa morir els errors de base de dades.
         */
    }

    private static boolean eliminarUsuari(String nomUsuari)
    {
        return CapaPersistencia.eliminarUsuari(nomUsuari);
        /*TODO:
            Si la capa de persistencia tira una excepcio normal en lloc d'una runtime (o controlem la runtime aqui), llavors podem morir "more gracefully" si mai borrem mes d'un usuari... PERO COM TAMPOC PASSARA MAI (GOD BLESS UNIQUE CONSTRAINTS), FUCK IT.
         */
    }

    public static Usuari getUsuariActual()
    {
        return usuariActual;
    }
}
