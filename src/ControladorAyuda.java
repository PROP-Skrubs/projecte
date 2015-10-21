public class ControladorAyuda {
   Casella casilla;
    Integer numero;

    public Integer getUltimo_puesto(){
        return numero;
    }
    public void setUltimo_puesto(Integer numero){
         this.numero = numero;
    }
    public Casella numero_siguiente(){
        /**
         * Retorna una Casella amb tota la informacio que pertoca per a poder omplir i saber a quin lloc s'ha de colocar
         */
        Integer numero = getUltimo_puesto();
        for(int x=0; x < CasillaSolucion.size();++x){
            for(int y=0;y<CasillaSolucion.size();++y){
                if(CasillaSolucion[x][y] == numero) {
                    Integer i, j;
                    i = x;
                    j = y;
                }
            }
        }
        casilla(x,y,numero);
        return casilla;
    }

}
