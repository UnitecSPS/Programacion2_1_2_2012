/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Herencia;

import java.util.Calendar;

/**
 *
 * @author Gotcha
 */
public class TestHerencia {
    public static void main(String args[]){
        //UPCASTINGS
        Empleado em1 = new EmpleadoPermanente(1,"ssdsd",5000);
        Empleado em2 = new EmpleadoTemporal(3,"Messi",4500);
        Empleado em4 = new EmpleadoPorHora( 4, "Pep");
        //NORMAL
        //Empleado em3 = new Empleado(2,"Sergio");
        
        //DOWNCASTINGS
        //INDIRECTA
        EmpleadoPorHora emh = (EmpleadoPorHora)em4;
        emh.setHorasT(70);
        System.out.println(em4);
        
        //DIRECTA
        //armar fecha
        Calendar c = Calendar.getInstance();
        c.set(2013, 11, 30);
        ((EmpleadoTemporal )em2).setFinContrato(c.getTime());
        System.out.println(em2);
        
        if( em2 instanceof EmpleadoTemporal )
            System.out.println("SI ES TEMP");
        else
            System.out.println("NO ES TEMP Y NO LO PUEDO CONVERTIR A EL");
        
        
        em1.fua();
        em2.fua();
        //em3.fua();
        
    }
}
