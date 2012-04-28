/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Herencia;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class CuentaCheques extends CuentaBancaria{
    public static int MIN_SALDO_INICIAL= 5000;
    private ArrayList<Cheque> chequesEmitidos;
    
    public CuentaCheques(int nc,String n){
        super(nc,n,MIN_SALDO_INICIAL);
        chequesEmitidos = new ArrayList<Cheque>();
    }
    
    public boolean cobrarCheque(Cheque ch){
        if( !verificar(ch.numeroCheque) &&
                hacerRetiro(ch.monto) ){
            chequesEmitidos.add( ch );
            return true;
        }
        return false;
    }
    
    public boolean verificar( int numCheque ){
        for(Cheque ch : chequesEmitidos ){
            if( numCheque == ch.numeroCheque )
                return true;
        }
        return false;
    }
    
    public void listarChequesEmitidos(){
        for( int ch = 0; ch < chequesEmitidos.size(); ch++){
            System.out.println( chequesEmitidos.get(ch) );
        }
    }

    @Override
    public void Fua() {
        System.out.println("SOY CHEQUERA");
    }
    
    
}
