/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package P2_640.ExamenLab1;

public abstract class ITEMRenta {
    protected String nombre;
    protected int codigo;
    protected double precio;
    protected int cantcopias;
    
    public ITEMRenta(int c,String n, double p, int cant){
        codigo=c;
        nombre=n;
        precio=p;
        cantcopias=cant;
    }

    public final int getCodigo() {
        return codigo;
    }

    public final String getNombre() {
        return nombre;
    }

    public final double getPrecio() {
        return precio;
    }
    
    public abstract double getMontoRenta(int dias);
    
    public void imprimir(){
        System.out.println("CODIGO: "+codigo+"\nNOMBRE: "+nombre+"\nPRECIO: "+precio+"\nCOPIAS: "+cantcopias);
    }
}
