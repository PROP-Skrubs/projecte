package CapaDomini;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oriol on 29/10/15.
 */
public class ControladorAjudes {
    public Casella help1(Hidato h){
        int x = h.getTauler().trobaPrimeraIncognitaAPartirDe(1);
        return h.getTaulerComplert().buscaCasella(x);
    }

    public List<Integer> help2(Integer i, Integer j, Hidato h) {
        List<Integer> candidatos_todos = new ArrayList<>();
        List<Integer> resultado = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        if (h.getTauler().getCasella(i, j).elem == 0) {   //Si la casilla no tiene numero colocado
            candidatos_todos = omplir_vex(h);
            resultado = quitar_puestos(candidatos_todos, h);
            res1 = quitar_resto(resultado, i, j, h);
        }
        return res1;
    }

    public List<Integer> quitar_resto(List<Integer> vector, Integer i, Integer j, Hidato h) {
        if (i-1 > 0) {    //Arriba //Si las variables i,j estan dentro del rango
            if (h.getTauler().getCasella(i - 1, j).elem != 0) {   //Si hay un numero colocado, miramos para cada candidato el rango
                for (int k = 0; k < vector.size(); k++) {
                    int auxi = vector.get(k);
                    if(Math.abs(auxi-h.getTauler().getCasella(i - 1, j).elem) != 1 ){
                        vector.remove((Integer)h.getTauler().getCasella(i - 1, j).elem);
                    }
                }
            }
        }
        if (i+1 < h.getTauler().getTamany()) {    //Abajo
            if (h.getTauler().getCasella(i + 1, j).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    int auxi = vector.get(k);
                    if(Math.abs(auxi-h.getTauler().getCasella(i + 1, j).elem) != 1 ){
                        vector.remove((Integer)h.getTauler().getCasella(i + 1, j).elem);
                    }
                }
            }
        }
        if (j-1 > 0) {    //Izquierda
            if (h.getTauler().getCasella(i, j - 1).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    int auxi = vector.get(k);
                    System.out.print("dd" + auxi);
                    if(!(Math.abs(auxi-h.getTauler().getCasella(i, j - 1).elem) == 1)){
                        System.out.print("Haid deliminar");
                        vector.remove((Integer)h.getTauler().getCasella(i, j - 1).elem);
                    }
                }
            }
        }
        if (j+1 < h.getTauler().getTamany()) {    //Derecha
            if (h.getTauler().getCasella(i, j + 1).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    int auxi = vector.get(k);
                    if(Math.abs(auxi-h.getTauler().getCasella(i, j + 1).elem) != 1 ){
                        vector.remove((Integer)h.getTauler().getCasella(i, j + 1).elem);
                    }
                }
            }
        }
        if (((i-1)>0) && ((j-1) > 0)) {    //Diagonal izq arriba
            if (h.getTauler().getCasella(i - 1, j - 1).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    int auxi = vector.get(k);
                    if(Math.abs(auxi-h.getTauler().getCasella(i - 1, j - 1).elem) != 1 ){
                        vector.remove((Integer)h.getTauler().getCasella(i - 1, j - 1).elem);
                    }
                }
            }
        }
        if (((i+1)<h.getTauler().getTamany()) && ((j-1)>0)) {    //Diagonal izq abajo
            if (h.getTauler().getCasella(i + 1, j - 1).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    int auxi = vector.get(k);
                    if(Math.abs(auxi-h.getTauler().getCasella(i + 1, j - 1).elem) != 1 ){
                        vector.remove((Integer)h.getTauler().getCasella(i + 1, j - 1).elem);
                    }
                }
            }
        }
        if (((i-1)>0) && ((j+1)<h.getTauler().getTamany())) {    //Diagonal derecha arriba
            if (h.getTauler().getCasella(i - 1, j + 1).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    int auxi = vector.get(k);
                    if(Math.abs(auxi-h.getTauler().getCasella(i - 1, j + 1).elem) != 1 ){
                        vector.remove((Integer)h.getTauler().getCasella(i - 1, j + 1).elem);
                    }
                }
            }
        }
        if (((i+1)<h.getTauler().getTamany()) && ((j+1)<h.getTauler().getTamany())) {    //Diagonal derecha abajo
            if (h.getTauler().getCasella(i + 1, j + 1).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    int auxi = vector.get(k);
                    if(Math.abs(auxi-h.getTauler().getCasella(i + 1, j + 1).elem) != 1 ){
                        vector.remove((Integer)h.getTauler().getCasella(i + 1, j + 1).elem);
                    }
                }
            }
        }

        return vector;
    }


    //Primer paso: Quitar de la lista los numeros que ya estan colocados en el tablero
    public List<Integer> quitar_puestos(List<Integer> vector, Hidato h) {
        List<Integer> listaaux = new ArrayList<>();
        for (int k = 0; k < h.getTauler().getTamany(); ++k) {
            for (int l = 0; l < h.getTauler().getTamany(); ++l) {
                if (h.getTauler().getCasella(k, l).elem != 0 && h.getTauler().getCasella(k, l).elem != -1) {
                    vector.remove((Integer)h.getTauler().getCasella(k, l).elem); //quito de la lista los numeros que ya estan colocados
                }
            }
        }
        return vector;
    }
    //Pongo en un vector todos los numeros posibles del tablero del 1 al n
    public List<Integer> omplir_vex(Hidato h){
        Integer n = h.getTauler().getTamany() * h.getTauler().getTamany();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(i + 1);
        }
        return l;
    }
    public void print(List<Integer> vector){
        for (Integer temp : vector) {
            System.out.println(temp);
        }
    }

}
