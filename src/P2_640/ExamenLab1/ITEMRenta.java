/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package P2_640.ExamenLab1;

public class ITEMRenta {
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

    protected int getCodigo() {
        return codigo;
    }

    protected String getNombre() {
        return nombre;
    }

    protected double getPrecio() {
        return precio;
    }
    
    protected double getMontoRenta(int dias){
        return 0;
    }
    
    protected void imprimir(){
        System.out.println("CODIGO: "+codigo+"\nNOMBRE: "+nombre+"\nPRECIO: "+precio+"\nCOPIAS: "+cantcopias);
    }
}
