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
public class EmpleadoTemporal extends EmpleadoPermanente{
    private Date finContrato;
    
    public EmpleadoTemporal(int c, String n, double s){
        super(c,n,s);
        finContrato = new Date();
    }
    
    @Override
    public void fua(){
        System.out.println("YA NO AGUANTO, FUUUUA");
    }

    @Override
    public double calcularPagoMensual() {
        Date now = new Date();
        
        if( now.before(finContrato)){
            return salario;
        }
        
        return 0;
    }
    
    
}
