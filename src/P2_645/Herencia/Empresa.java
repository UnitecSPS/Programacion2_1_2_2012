/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Herencia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Empresa {
    private ArrayList<Empleado> empleados;
    
    public final static int TIPO_PERMANENTE = 0;
    public final static int TIPO_TEMPORAL = 1;
    public final static int TIPO_PORHORA = 2;
         
    
    public Empresa(){
        empleados = new ArrayList<Empleado>();
    }
    
    public void agregarEmpleado(int tipo){
        Scanner lea = new Scanner(System.in);
        int cod = lea.nextInt();
        String n = lea.next();
        
        if( tipo == TIPO_PERMANENTE ){
            double sal = lea.nextDouble();
            Empleado e = new EmpleadoPermanente(cod,n,sal);
            empleados.add(e);
        }
        else if ( tipo == TIPO_TEMPORAL ){
            double sal = lea.nextDouble();
            Empleado e = new EmpleadoTemporal(cod,n,sal);
            empleados.add(e);
        }
        else if( tipo == TIPO_PORHORA ){
            Empleado e = new EmpleadoPorHora(cod,n);
            empleados.add(e);
        }
        else{
            System.out.println("TIPO NO EXISTE");
        }
    }
    
    public void listarEmpleados(){
        for(Empleado e : empleados ){
            System.out.println(e);
        }
    }
}
