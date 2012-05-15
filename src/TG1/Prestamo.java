/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG1;

/**
 *
 * @author Gotcha
 */

public abstract class Prestamo {
    
    protected double montoPrestamo;
    protected String nombre;
    protected Cuota cuotas[];
    
    public Prestamo(double m, String n, int cant){
        montoPrestamo = m;
        nombre = n;
        double cuota = m / cant;
        cuotas = new Cuota[ cant ];
        inicializarCuotas(cuota);
    }

    private void inicializarCuotas( double monto ) {
        for(int c=0; c < cuotas.length; c++ ){
            cuotas[c] = new Cuota( monto );
        }
    }

    public final Cuota[] getCuotas() {
        return cuotas;
    }

    public final double getMontoPrestamo() {
        return montoPrestamo;
    }

    public final String getNombre() {
        return nombre;
    }
    
    public abstract void imprimir();
}
















