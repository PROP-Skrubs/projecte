package CapaDomini;

/**
 * Created by daniel on 29/10/15.
 */
public class ControladorUsuari
{
    public static boolean crearUsuari(String nomUsuari, String contrasenya, String nomReal)
    {
        Usuari u = new Usuari();
        u.setNomUsuari(nomUsuari);
        u.setContrasenya(contrasenya);
        u.setNomReal(nomReal);
        return CapaPersistencia.ControladorUsuari.crearUsuari(u);
        /*TODO:
            Controlar les excepcions i el resultat de la operacio.
              ^en principi ja es controla tot lo necessari (basicament si es crea o no l'user) i es deixa morir els errors de base de dades.
         */
    }

    private static boolean eliminarUsuari(String nomUsuari)
    {
        //Retorna true si s'ha borrat l'usuari. False si no s'ha borrat cap usuari. Tira excepcio si s'han borrat multiples.
        return CapaPersistencia.ControladorUsuari.eliminarUsuari(nomUsuari);
        /*TODO:
            Si la capa de persistencia tira una excepcio normal en lloc d'una runtime (o controlem la runtime aqui), llavors podem morir "more gracefully" si mai borrem mes d'un usuari... PERO COM TAMPOC PASSARA MAI (GOD BLESS UNIQUE CONSTRAINTS), FUCK IT.
         */
    }
}
