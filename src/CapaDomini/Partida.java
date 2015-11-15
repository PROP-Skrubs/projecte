package CapaDomini;

/**
 * Created by Maria on 10/11/2015.
 */
public class Partida
{
    int uniqID;
    int idHidato;
    int idUser;
    int nCelesResoltes;
    int numAjudesUtilitzades;
    Tauler taulerProgres;
    boolean esAcabada;

    public int getIdHidato()
    {
        return idHidato;
    }

    public void setIdHidato(int idHidato)
    {
        this.idHidato = idHidato;
    }

    public int getIdUser()
    {
        return idUser;
    }

    public void setIdUser(int idUser)
    {
        this.idUser = idUser;
    }

    public int getUniqID()
    {
        return uniqID;
    }

    public void setUniqID(int uniqID)
    {
        this.uniqID = uniqID;
    }

    public int getnCelesResoltes()
    {
        return nCelesResoltes;
    }

    public void setnCelesResoltes(int nCelesResoltes)
    {
        this.nCelesResoltes = nCelesResoltes;
    }

    public int getNumAjudesUtilitzades()
    {
        return numAjudesUtilitzades;
    }

    public void setNumAjudesUtilitzades(int numAjudesUtilitzades)
    {
        this.numAjudesUtilitzades = numAjudesUtilitzades;
    }

    public Boolean getEsAcabada()
    {
        return esAcabada;
    }

    public void setEsAcabada(Boolean esAcabada)
    {
        this.esAcabada = esAcabada;
    }

    public Partida()
    {
    }
}
