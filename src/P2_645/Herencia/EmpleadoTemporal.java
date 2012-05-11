/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Herencia;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public final class EmpleadoTemporal extends EmpleadoPermanente{
    private Date finContrato;
    
    public EmpleadoTemporal(int c, String n, double s){
        super(c,n,s);
        finContrato = new Date();
    }

    public Date getFinContrato() {
        return finContrato;
    }

    public void setFinContrato(Date finContrato) {
        this.finContrato = finContrato;
    }
    
    @Override
    public void fua(){
        System.out.println("YA NO AGUANTO, FUUUUA");
    }

    @Override
    public double calcularPagoMensual() {
        double f = super.calcularPagoMensual();
        Date now = new Date();
        
        if( now.before(finContrato)){
            return salario;
        }
        
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Contrato Finaliza: " +
                finContrato;
    }
    
    
    
    
}
