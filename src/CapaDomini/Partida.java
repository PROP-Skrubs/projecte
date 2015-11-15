package CapaDomini;

/**
 * Created by Maria on 10/11/2015.
 */
public class Partida {
    Integer idpartida;
    Integer idhidato;
    Integer iduser;
    Integer ncelesresolt;
    Integer numajd;
    Casella[][] matriu;
    Boolean acabat;

    public Integer getIdhidato() {
        return idhidato;
    }

    public void setIdhidato(Integer idhidato) {
        this.idhidato = idhidato;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIdpartida() {
        return idpartida;
    }

    public void setIdpartida(Integer idpartida) {
        this.idpartida = idpartida;
    }

    public Integer getNcelesresolt() {
        return ncelesresolt;
    }

    public void setNcelesresolt(Integer ncelesresolt) {
        this.ncelesresolt = ncelesresolt;
    }

    public Integer getNumajd() {
        return numajd;
    }

    public void setNumajd(Integer numajd) {
        this.numajd = numajd;
    }

    public Casella[][] getMatriu() {
        return matriu;
    }

    public void setMatriu(Casella[][] matriu) {
        this.matriu = matriu;
    }

    public Boolean getAcabat() {
        return acabat;
    }

    public void setAcabat(Boolean acabat) {
        this.acabat = acabat;
    }

    public  Partida(){};
}
