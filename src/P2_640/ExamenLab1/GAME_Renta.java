/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package P2_640.ExamenLab1;

import java.util.Calendar;

public class GAME_Renta extends ITEMRenta {
    protected String type;
    
    public final static String PS3="PS3";
    final public static String XBOX360="XBOX360";
    public static final String WII="WII";
 
    public GAME_Renta(int c, String n, double p, int cant, String t){
        super(c,n,p,cant);
        type = t;
    }

    @Override
    public double getMontoRenta(int dias) {
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
    public void imprimir() {
        super.imprimir();
        System.out.println(" CONSOLA: "+type);
    }
}
