/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Herencia;

/**
 *
 * @author Gotcha
 */
public class EmpleadoPermanente extends Empleado{
    protected double salario;
    protected boolean hasSeguro;  
       
    public EmpleadoPermanente(int c , String n,double s){
        super(c,n);
        hasSeguro = false;
        salario = s;
        super.getCodigo();
    }

    public void setHasSeguro(boolean hasSeguro) {
        this.hasSeguro = hasSeguro;
    }

    public boolean isHasSeguro() {
        return hasSeguro;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public double calcularPagoMensual() {
        double rap = salario * 0.035;
        double ihss = 84;
        
        if( salario > 4800 )
            ihss = salario * 0.035;
        
        double recargo = 0;
        if( hasSeguro )
            recargo = 10;
        
        return salario - (rap + ihss + recargo);
    }

    @Override
    public String toString() {
        return super.toString() + " - " + salario;
    }
    
    @Override
    public void fua(){
        System.out.println("SACAR EL CARACTER, FUUUUA!");
    }
    
    public void fuaAbuela(){
        super.fua();
    }
    
    
}
