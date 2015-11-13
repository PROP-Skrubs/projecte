package CapaDomini;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by oriol on 29/10/15.
 */
public class ControladorAjudes {
    public Casella help1(Hidato h){
        int x = h.getTauler().trobaPrimeraIncognita();
        return h.getTauler().buscaNumero(x);
    }

    public List<Integer> help2(Integer i, Integer j, Hidato h) {
        List<Integer> candidatos_todos = null;
       
        if (h.getTauler().getCasella(i, j).elem == 0) {   //Si la casilla no tiene numero colocado
            candidatos_todos = omplir_vex(h);
            List<Integer> res1 = quitar_puestos(candidatos_todos, i, j, h);
            List<Integer> res11 = quitar_resto(res1, i, j, h);
            return res11;
        }
        return candidatos_todos;
    }

    //Primer paso: Quitar de la lista los numeros que ya estan colocados en el tablero
    public List<Integer> quitar_puestos(List<Integer> vector, Integer i, Integer j, Hidato h) {
        int result[] = new int[h.getTauler().tamany()];
        for (int k = 0; k < h.getTauler().tamany(); ++k) {
            for (int l = 0; l < h.getTauler().tamany(); ++l) {
                if (h.getTauler().getCasella(k, l).elem != 0) {
                    vector.remove(h.getTauler().getCasella(k, l).elem); //quito de la lista los numeros que ya estan colocados
                }
            }
        }
        return vector;
    }
    //Pongo en un vector todos los numeros posibles del tablero del 1 al n
    public List<Integer> omplir_vex(Hidato h){
        Integer n = h.getTauler().tamany();
        List<Integer> candidats = null;
        for(int i =1; i<=n; ++i){
            candidats.set(i, i);    //meto en la lista todos los numero posibles
        }
        return candidats;
    }
    public void print(List<Integer> vector){
        for (Integer temp : vector) {
            System.out.println(temp);
        }
    }

    public List<Integer> quitar_resto(List<Integer> vector, Integer i, Integer j, Hidato h) {
        if (i-1 > 0) {    //Arriba //Si las variables i,j estan dentro del rango
            if (h.getTauler().getCasella(i - 1, j).elem != 0) {   //Si hay un numero colocado, miramos para cada candidato el rango
                for (int k = 0; k < vector.size(); k++) {
                    if(Math.abs(k-h.getTauler().getCasella(i - 1, j).elem) != 1 ){
                        vector.remove(h.getTauler().getCasella(i - 1, j).elem);
                    }
                }
            }
        }
        if (i+1 < h.getTauler().tamany()) {    //Abajo
            if (h.getTauler().getCasella(i + 1, j).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    if(Math.abs(k-h.getTauler().getCasella(i + 1, j).elem) != 1 ){
                        vector.remove(h.getTauler().getCasella(i + 1, j).elem);
                    }
                }
            }
        }
        if (j-1 > 0) {    //Izquierda
            if (h.getTauler().getCasella(i, j - 1).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    if(Math.abs(k-h.getTauler().getCasella(i, j - 1).elem) != 1 ){
                        vector.remove(h.getTauler().getCasella(i, j - 1).elem);
                    }
                }
            }
        }
        if (j+1 < h.getTauler().tamany()) {    //Derecha
            if (h.getTauler().getCasella(i, j + 1).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    if(Math.abs(h.getTauler().getCasella(i, j + 1).elem) != 1 ){
                        vector.remove(h.getTauler().getCasella(i, j + 1).elem);
                    }
                }
            }
        }
        if (((i-1)>0) && ((j-1) > 0)) {    //Diagonal izq arriba
            if (h.getTauler().getCasella(i - 1, j - 1).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    if(Math.abs(k-h.getTauler().getCasella(i - 1, j - 1).elem) != 1 ){
                        vector.remove(h.getTauler().getCasella(i - 1, j - 1).elem);
                    }
                }
            }
        }
        if (((i+1)<h.getTauler().tamany()) && ((j-1)>0)) {    //Diagonal izq abajo
            if (h.getTauler().getCasella(i + 1, j - 1).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    if(Math.abs(k-h.getTauler().getCasella(i + 1, j - 1).elem) != 1 ){
                        vector.remove(h.getTauler().getCasella(i + 1, j - 1).elem);
                    }
                }
            }
        }
        if (((i-1)>0) && ((j+1)<h.getTauler().tamany())) {    //Diagonal derecha arriba
            if (h.getTauler().getCasella(i - 1, j + 1).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    if(Math.abs(k-h.getTauler().getCasella(i - 1, j + 1).elem) != 1 ){
                        vector.remove(h.getTauler().getCasella(i - 1, j + 1).elem);
                    }
                }
            }
        }
        if (((i+1)<h.getTauler().tamany()) && ((j+1)<h.getTauler().tamany())) {    //Diagonal derecha abajo
            if (h.getTauler().getCasella(i + 1, j + 1).elem != 0) {
                for (int k = 0; k < vector.size(); k++) {
                    if(Math.abs(k-h.getTauler().getCasella(i + 1, j + 1).elem) != 1 ){
                        vector.remove(h.getTauler().getCasella(i + 1, j + 1).elem);
                    }
                }
            }
        }

        return vector;
    }

    public void ajuda1(Hidato h){
        ControladorAjudes ca = new ControladorAjudes();
        Casella c = new Casella();
        c = ca.help1(h);
        System.out.println("Jo de tu posaria el numero" + c.elem + " a les posicions x:" + c.x + " y:" + c.y);
    }
    public void ajuda2(Hidato h){
        ControladorAjudes ca = new ControladorAjudes();
        Scanner capt = new Scanner(System.in);
        System.out.println("introdueix X:");
        int x = capt.nextInt();
        while (x < 1 | x > h.getTauler().getLongitud()) {
            System.out.println("X no valida, introdueix una altra");
            x = capt.nextInt();
        }

        System.out.println("introdueix Y:");
        int y = capt.nextInt();
        while (y < 1 | y > h.getTauler().getLongitud()) {
            System.out.println("Y no valida, introdueix una altra");
            y = capt.nextInt();
        }
        List<Integer> l = ca.help2(x, y, h);
        Iterator<Integer> it = l.iterator();
        System.out.println("Possibles Candidats:");
        while (it.hasNext()) {
            System.out.print(" " + it.next());

        }
        System.out.print("\n");
    }

}
