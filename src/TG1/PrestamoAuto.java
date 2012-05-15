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
public class PrestamoAuto extends Prestamo implements iPrestamo {
    private String serie;
    private Cuota seguro[];
    
    public PrestamoAuto(double m,String c,int cant,String s){
        super( m, c , cant);
        serie = s;
        
        inicializarSeguro();
    }

    private void inicializarSeguro() {
        seguro = new Cuota[ cuotas.length ];
        double montoSeguro = montoPrestamo * 0.3;
        
        for( int s=0; s < seguro.length ; s++ )
            seguro[ s ] = new Cuota( montoSeguro / seguro.length );
    }

    @Override
    public void imprimir() {
        System.out.println("Auto Prestamo por Lps " + montoPrestamo + " a " +
                nombre);
    }

    @Override
    public double getTasaInteres() {
        return 0.25;
    }

    @Override
    public double saldoPendiente() {
        double pendiente = 0;
        
        for( int c=0 ; c < seguro.length ; c++ ){
            if( !cuotas[c].pagada )
                pendiente += cuotas[c].monto;
            if( !seguro[c].pagada )
                pendiente += seguro[c].monto;
        }
        return pendiente;
    }

    @Override
    public boolean pagarCuota(int ncuota) {
        if( ncuota < cuotas.length ){
            cuotas[ncuota].pagada = true;
            cuotas[ncuota].fechaDePago = new Date();
            
            seguro[ncuota].pagada = true;
            seguro[ncuota].fechaDePago = new Date();
            return true;
        }
        return false;
    }
}
