/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Interfaces;

/**
 *
 * @author Gotcha
 */
public class TestArreglos {
    public static void main(String args[]){
        Arreglo a1 = new ArregloEnteros();
        Arreglo a2 = new ArregloCadenas();
        
        a1.agregarElemento("dsds");
        a1.agregarElemento(1);
        a1.agregarElemento(2);
        
        a2.agregarElemento(1);
        a2.agregarElemento("Carlos");
        a2.agregarElemento("Armando");
        
        a1.imprimir();
        System.out.println("\n\n");
        a2.imprimir();
        
        //-----------------
        ArregloEnteros ae = new ArregloEnteros();
        
    }
}


