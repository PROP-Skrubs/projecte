/**
 * Created by oriol on 15/10/15.
 */
public class ControladorPartida
{


    public boolean validar_progres(Integer element){
        /**
         * Retorna true en cas que el valor posat a la posicio x,y sigui igual al del tauler solucio
         * Aquesta funcio accepta un Hidato on el seu tauler complert és buit i el d'usuari conte un Hidato que s'ha de validar.
         */
        return (Casilla[x][y] == CasillaSolucion[x][y]);
    }
    public void setCasella(int x, int y, int elem) {
        /**
         * Aquesta funcio posa el valor element a la posicio x,y que toca
         */
        if(vaildar_progres(elem)) {
            Casella[x][y] = elem;
        }
        else {
            System.out.println ("El precio es de " + precio + " euros");
        }
    }


}
