/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package P2_640.ExamenLab1;

public class GAME_Renta extends ITEMRenta {
    protected String type;
    
    protected static String PS3="PS3";
    protected static String XBOX360="XBOX360";
    protected static String WII="WII";
 
    public GAME_Renta(int c, String n, double p, int cant, String t){
        super(c,n,p,cant);
        type = t;
    }

    @Override
    protected double getMontoRenta(int dias) {
        if(type.equals(PS3)||type.equals(XBOX360)){
            cantcopias-=1;
            if(dias<=3)
                return precio;
            else
                return precio+(precio*0.6)*(dias-3);           
        }else if(type.equals(WII)){
            cantcopias-=1;
            if(dias<=5)               
                return precio;
            else
                return precio+(precio*0.5)*(dias-5);
        }else{
            return 0;
        }
    }

    @Override
    protected void imprimir() {
        super.imprimir();
        System.out.println(" CONSOLA: "+type);
    }
}
