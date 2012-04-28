/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Herencia;

/**
 *
 * @author Gotcha
 */
public class BAC {
    public static void main(String args[]){
        //UPCASTINGS
        CuentaBancaria cb1 = new CuentaAhorro(1,"Messi",0.5);
        CuentaBancaria cb2 = new CuentaPlazoFijo(3,"Kaka");
        CuentaBancaria cb4 = new CuentaCheques(4,"PEP");
        //NORMAL
        CuentaBancaria cb3 = new CuentaBancaria(2,"Dany",100);
        
        //DOWNCASTING
        //INDIRECTA
        CuentaAhorro cah = (CuentaAhorro)cb1;
        cah.setTasaInteres(0.08);
        System.out.println(cb1);
        
        //DIRECTA
        ((CuentaCheques)cb4).cobrarCheque( new Cheque(1,"Christian",1000) );
        ((CuentaCheques)cb4).cobrarCheque( new Cheque(2,"Oscar",1500));
        ((CuentaCheques)cb4).listarChequesEmitidos();
        System.out.println(cb4);
        
        Object o = 7;
        if( o instanceof Integer ){
            System.out.println("SI SOS FIJA!");
        }
        else{
            System.out.println("NO ES FIJA NO LO CONVIRTAS A FIJA!");
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        Banco b = new Banco();
        
        b.agregarCuenta( Banco.TIPO_AHORRO );
        b.agregarCuenta( Banco.TIPO_CHEQUES );
        b.agregarCuenta( Banco.TIPO_PLAZOFIJO );
        
        b.listarCuentas();
        
    }
}
