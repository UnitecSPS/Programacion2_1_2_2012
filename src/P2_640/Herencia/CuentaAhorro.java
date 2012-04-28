/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Herencia;

/**
 *
 * @author Gotcha
 */
public class CuentaAhorro extends CuentaBancaria{
    
    protected double tasaInteres;
    protected boolean activa;
    public static int MIN_SALDO_INICIAL= 500;
    public static double RECARGO_INACTIVA = 0.02;
    
    public CuentaAhorro(int nc,String n,double ts){
        super(nc, n, MIN_SALDO_INICIAL);
        tasaInteres = ts;
        activa = true;  
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public boolean isActiva() {
        return activa;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    @Override
    public void hacerDeposito(double monto) {
        if( activa )
            super.hacerDeposito(monto);
        else{
            double rec = activarConRecargo(monto);
            super.hacerDeposito(monto - rec);
        }
    }
    
    private double activarConRecargo(double monto){
        activa = true;
        return monto * RECARGO_INACTIVA;
    }

    @Override
    public boolean hacerRetiro(double monto) {
        if( activa )
            return super.hacerRetiro(monto);
        else{
            double rec = activarConRecargo(monto);
            boolean status = super.hacerRetiro(monto + rec);
            
            if(!status)
                activa = false;
            return status;
        }
    }
    
    public void registroIntereses(){
        saldo += saldo * tasaInteres;
    }
    
    @Override
    public void Fua(){
        System.out.println("SOY LA DE AHORRO");
    }

    @Override
    public String toString() {
        return super.toString() + " - tasa Interes: " + 
                tasaInteres;
    }
    
    
}
