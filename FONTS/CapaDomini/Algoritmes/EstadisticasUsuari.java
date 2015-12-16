package CapaDomini.Algoritmes;

/**
 * Created by Maria on 01/12/2015.
 */
public class EstadisticasUsuari extends EstadisticasHidato{
    int idUsuari;

    /**
     * Retorna el idUsuari
     * @return el idUsuari
     */
    public int getIdUsuari() {
        return idUsuari;
    }

    /**
     * Modifica el idUsuari
     * @param idUsuari el nou idUsuari
     */
    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    /**
     * Creadora buida de la classe
     */
    public EstadisticasUsuari()
    {
        super();
        idUsuari = -1;
    }

    /**
     * Creadora de la classe
     * @param idHidato el idHidato que tindra
     * @param idUsuari el idUsuari que tindra
     */
    public EstadisticasUsuari( int idHidato,int idUsuari) {
        super(idHidato);
        this.idUsuari = idUsuari;
    }
}
