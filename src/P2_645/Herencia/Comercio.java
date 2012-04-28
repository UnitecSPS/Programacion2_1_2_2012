/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Herencia;

/**
 *
 * @author Gotcha
 */
public class Comercio {
    public static void main(String args[]){
        Empresa empresa = new Empresa();
        
        empresa.agregarEmpleado(Empresa.TIPO_PERMANENTE);
        empresa.agregarEmpleado(Empresa.TIPO_PORHORA);
        empresa.agregarEmpleado(Empresa.TIPO_TEMPORAL);
        
        empresa.listarEmpleados();
    }
}
