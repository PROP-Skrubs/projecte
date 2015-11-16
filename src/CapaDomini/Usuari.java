package CapaDomini;

/**
 * Created by daniel on 13/10/15.
 */
public class Usuari
{
    private int uniqID;
    private String nomUsuari;
    private String contrasenya;
    private String nomReal;

    public Usuari()
    {
        /**
         * Crea un Usuario vacio
         */
        uniqID = -1;
    }

    public Usuari(int id, String nomU, String contra, String nomR)
    {
        uniqID = id;
        nomUsuari = nomU;
        contrasenya = contra;
        nomReal = nomR;
    }

    public Usuari(Usuari u)
    {
        uniqID = u.getUniqID();
        nomUsuari = u.getNomUsuari();
        contrasenya = u.getContrasenya();
        nomReal = u.getNomReal();
    }

    public int getUniqID()
    {

        /**
         * Retorna el UniqID
         */
        return uniqID;
    }

    public void setUniqID(int uniqID)
    {
        /**
         * Modifica el uniqID ficant un enter pasat per paràmetres
         */
        this.uniqID = uniqID;
    }

    public String getContrasenya()
    {
        /**
         * Retorna la contrasenya
         */
        return contrasenya;
    }

    public void setContrasenya(String contrasenya)
    {
        /**
         * Modifica el uniqID ficant la contrasenya pasada per paràmetres
         */
        this.contrasenya = contrasenya;
    }

    public String getNomUsuari()
    {
        /**
         * Retorna el nomUsuari
         */
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari)
    {
        /**
         * Modifica el nomUsuari ficant el nomUsuair passat per paràmetres
         */
        this.nomUsuari = nomUsuari;
    }

    public boolean validaContrasenya(String altraContrasenya)
    {
        /**
         * Et Retorna si la contrasenya pasada per parametres es iguala a la Contrasenya
         */
        return altraContrasenya.compareTo(contrasenya) == 0;
    }

    public String getNomReal()
    {
        /**
         * Retorna el NomReal
         */
        return nomReal;
    }

    public void setNomReal(String nomReal)
    {
        /**
         * Modifica el nomReal ficant el nomReal passat per paràmetres
         */
        this.nomReal = nomReal;
    }
}
