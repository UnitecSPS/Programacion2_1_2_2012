/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Herencia;

/**
 *
 * @author Gotcha
 */
public class EmpleadoPorHora extends Empleado{
    private int horasT;
    public static double PAGO_HORA_NORMAL = 40;
    public static double PAGO_HORA_EXTRA = 60;
    
    public EmpleadoPorHora(int c, String n){
        super(c,n);
    }

    public int getHorasT() {
        return horasT;
    }

    public void setHorasT(int horasT) {
        this.horasT = horasT;
    }
    
    @Override
    public double calcularPagoMensual() {
        
        double tn, te = 0;
        
        if( horasT <= 40 )
            tn = horasT * PAGO_HORA_NORMAL;
        else{
            tn = 40 * PAGO_HORA_NORMAL;
            te = (horasT - 40) * PAGO_HORA_EXTRA;
        }
        
        return tn + te;    
    }

    @Override
    public String toString() {
        return super.toString() + " Horas Trabajadas: "+
                horasT;
    } 
}
