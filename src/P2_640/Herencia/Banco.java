/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Herencia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Banco {
    private ArrayList<CuentaBancaria> cuentas;
    
    public static int TIPO_AHORRO = 0;
    public static int TIPO_PLAZOFIJO = 1;
    public static int TIPO_CHEQUES = 2;
    
    public Banco(){
        cuentas = new ArrayList<CuentaBancaria>();
    }
    
    public void agregarCuenta(int tipo){
        Scanner lea = new Scanner(System.in);
        
        int nc = lea.nextInt();
        String n = lea.next();
        
        if( tipo == TIPO_AHORRO ){
            double tasa = lea.nextDouble();
            cuentas.add( new CuentaAhorro(nc, n, tasa) );
        }
        else if( tipo == TIPO_PLAZOFIJO ){
            cuentas.add( new CuentaPlazoFijo(nc, n) );
        }
        else if( tipo == TIPO_CHEQUES ){
            cuentas.add( new CuentaCheques(nc, n) );
        }
        else
            System.out.println("TIPO INCORRECTO");
        
    }
    
    public void listarCuentas(){
        for( CuentaBancaria cb : cuentas ){
            cb.Fua();
        }
    }
    
}