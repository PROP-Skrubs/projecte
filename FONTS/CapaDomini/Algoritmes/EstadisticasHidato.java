package CapaDomini.Algoritmes;

import java.util.List;

/**
 * Created by Maria on 01/12/2015.
 */
public class EstadisticasHidato {
    int idHidato;
    int intents;
    int cops_res;
    int temps_mig;
    int ajudes;

    /**
     * Creadora de la classe
     * @param idHidato El Hidato del cual es copia tota la informacio
     */
    public EstadisticasHidato( int idHidato) {
        this.idHidato = idHidato;
        this.intents = 0;
        this.cops_res = 0;
        this.temps_mig = 0;
        this.ajudes = 0;
    }

    /**
     * Creadora buida de la classe
     */
    public EstadisticasHidato( ) {
    }

    /**
     * Retorna el id del Hidato
     * @return el id del Hidato
     */
    public int getIdHidato() {
        return idHidato;
    }

    /**
     * Modifica el id del Hidato
     * @param idHidato el nou id
     */
    public void setIdHidato(int idHidato) {
        this.idHidato = idHidato;
    }

    /**
     * Retorna els intents
     * @return els intents
     */
    public int getIntents() {
        return intents;
    }

    /**
     * Modicia els intents
     * @param intents els nous intents
     */
    public void setIntents(int intents) {
        this.intents = intents;
    }

    /**
     * Retorna el nombre de cops que ha sigut resolt l'Hidato
     * @return el nombre de cops que ha sigut resolt l'Hidato
     */
    public int getCops_res() {
        return cops_res;
    }

    /**
     * Modifoca el nombre de cops que ha sigut resolt l'Hidato
     * @param cops_res el nou nombre de cops que ha sigut resolt l'Hidato
     */
    public void setCops_res(int cops_res) {
        this.cops_res = cops_res;
    }

    /**
     * Retorna el temps mig en el qual es resol l'Hidato
     * @return el temps mig en el qual es resol l'Hidato
     */
    public int getTemps_mig() {
        return temps_mig;
    }

    /**
     * Modifica el temps mig en el qual es resol l'Hidato
     * @param temps_mig el nou temps mig en el qual es resol l'Hidato
     */
    public void setTemps_mig(int temps_mig) {
        this.temps_mig = temps_mig;
    }

    /**
     * Retorna el nombre d'ajudes que ha utilitzat per resoldre l'Hidato
     * @return el nombre d'ajudes que ha utilitzat per resoldre l'Hidato
     */
    public int getAjudes() {
        return ajudes;
    }

    /**
     * Modifica el nombre d'ajudes que ha utilitzat per resoldre l'Hidato
     * @param ajudes El nou nombre d'ajudes que ha utilitzat per resoldre l'Hidato
     */
    public void setAjudes(int ajudes) {
        this.ajudes = ajudes;
    }

    int ger_ratio(){
        return (cops_res/intents)*100;
    }
}
