/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG1;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class PrestamoVivienda extends Prestamo implements iPrestamo {

    private boolean banprovi;
    
    public PrestamoVivienda(double m,String c,int cant,boolean b){
        super( m, c, cant );
        banprovi = b;
    }
    
    @Override
    public void imprimir() {
        System.out.println("Monto Prestamo: " + montoPrestamo);
        System.out.println("A nombre de: " + nombre);
        System.out.println("DETALLE DE CUOTAS\n-------------");
        
        int numero = 0;
        for(Cuota c : cuotas){
            System.out.println(numero + " - " + c);
            numero++;
        }
    }

    @Override
    public double getTasaInteres() {
        return banprovi ? 0.1 : 0.2;
    }

    @Override
    public double saldoPendiente() {
        double pendiente = 0;
        for(Cuota c : cuotas){
            if( !c.pagada )
                pendiente += c.monto;
        }
        if( pendiente > 0 )
            pendiente += 57000;
        return pendiente;
    }

    @Override
    public boolean pagarCuota(int ncuota) {
        if( ncuota < cuotas.length && !cuotas[ncuota].pagada ){
            cuotas[ncuota].pagada = true;
            cuotas[ncuota].fechaDePago = new Date();
            return true;
        }
        return false;
    }
    
}
