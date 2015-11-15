package CapaDomini;

/**
 * Created by daniel on 13/10/15.
 */
public class Usuari
{
    private String nomUsuari;
    private String contrasenya;
    private String nomReal;

    public Usuari()
    {

    }

    public String getContrasenya()
    {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya)
    {
        this.contrasenya = contrasenya;
    }

    public String getNomUsuari()
    {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari)
    {
        this.nomUsuari = nomUsuari;
    }

    public boolean validaContrasenya(String altraContrasenya)
    {
        return altraContrasenya.compareTo(contrasenya) == 0;
    }

    public String getNomReal()
    {
        return nomReal;
    }

    public void setNomReal(String nomReal)
    {
        this.nomReal = nomReal;
    }
}
