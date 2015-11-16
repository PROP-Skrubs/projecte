package CapaDomini;

import CapaPersistencia.GestorUsuari;

/**
 * Created by daniel on 29/10/15.
 */
public class ControladorUsuari
{
    public static boolean crearUsuari(String nomUsuari, String contrasenya, String nomReal)
    {
        /**Crea un Usuari amb els valors passat per paràmetre.
         */
        Usuari u = new Usuari();
        u.setNomUsuari(nomUsuari);
        u.setContrasenya(contrasenya);
        u.setNomReal(nomReal);
        return GestorUsuari.creaUsuari(u); //todo aixo ara es diu "guardar usuari"
        /*TODO:
            Controlar les excepcions i el resultat de la operacio.
              ^en principi ja es controla tot lo necessari (basicament si es crea o no l'user) i es deixa morir els errors de base de dades.
         */
    }

    public static boolean eliminarUsuari(String nomUsuari)
    {   /**Elimina el Usuari que tingui el nomUsuari passat per paràmetre
         */

        //Retorna true si s'ha borrat l'usuari. False si no s'ha borrat cap usuari. Tira excepcio si s'han borrat multiples.
        return GestorUsuari.eliminaUsuari(nomUsuari); //todo aixo ara es diu god knows how
        /*TODO:
            Si la capa de persistencia tira una excepcio normal en lloc d'una runtime (o controlem la runtime aqui), llavors podem morir "more gracefully" si mai borrem mes d'un usuari... PERO COM TAMPOC PASSARA MAI (GOD BLESS UNIQUE CONSTRAINTS), FUCK IT.
         */
    }
}
