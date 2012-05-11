/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Herencia;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class CuentaPlazoFijo extends CuentaAhorro{
    private Date fin;
    private double interesesGanados;
    public static double TASA_FIJA = 0.2;
    
    public CuentaPlazoFijo(int nc,String n){
        super(nc,n,TASA_FIJA);
        fin = inicio;
        interesesGanados = 0;
        
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Date getFin() {
        return fin;
    }

    public double getInteresesGanados() {
        return interesesGanados;
    }

    @Override
    public boolean hacerRetiro(double monto) {
        Date now = new Date();
        if( now.before(fin) && activa){
            if( interesesGanados > monto ){
                interesesGanados -= monto;
                return true;
            }
        }
        return false;
    }

    @Override
    public void registroIntereses() {
        double inte = saldo * tasaInteres;
        saldo += inte;
        interesesGanados += inte;
    }
    
    @Override
    public void Fua(){
        System.out.println("SOY LA DE AHORRO FIJO");
    }
    
    
    
    
}
