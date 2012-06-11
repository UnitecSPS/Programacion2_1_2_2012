/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Archivos;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author CarlosArmando
 */
public class BAC {
    
    public static void main(String args[]){
        JBank bank =new JBank();
        int op=0;
        Scanner lea = new Scanner(System.in);
        
        do{
            try{
                System.out.println("\n1-Agregar Cuenta");
                System.out.println("2-Listar Cuentas");
                System.out.println("3-Buscar Cuenta");
                System.out.println("4-Depositar");
                System.out.println("5-Retirar");
                System.out.println("6-Inactivar Cuentas");
                System.out.println("7-Libreta");
                System.out.println("8-Registrar Intereses");
                System.out.println("9-Exportar");
                System.out.println("10-Salir");
                System.out.print("\nEscoja Opcion: ");
                op = lea.nextInt();
                
                switch( op ){
                    case 1:
                        System.out.println("Ingrese Nombre: ");
                        bank.addCuenta(lea.next());
                        break;
                    case 2:
                        System.out.println("Listar Activas (s) o Inactivas (n)?: ");
                        char resp = lea.next().charAt(0);
                        bank.listar( resp == 's' ? true : false );
                        break;
                    case 3:
                        System.out.println("Ingrese Codigo a buscar: ");
                        if( bank.buscar(lea.nextInt()) )
                            System.out.println("La Cuenta Existe");
                        else
                            System.out.println("La Cuenta NO existe");
                        break;
                    case 4:
                        System.out.println("Codigo Cuenta: ");
                        int cc = lea.nextInt();
                        System.out.println("Monto a depositar: ");
                        double m = lea.nextDouble();
                        
                        if( bank.deposito(cc, m))
                            System.out.println("Deposito exitoso");
                        else
                            System.out.println("No se pudo hacer deposito");
                        break;
                    case 5:
                        System.out.println("Codigo Cuenta: ");
                        cc = lea.nextInt();
                        System.out.println("Monto a retirar: ");
                        m = lea.nextDouble();
                        
                        if( bank.retiro(cc, m))
                            System.out.println("Retiro exitoso");
                        else
                            System.out.println("No se pudo hacer retirar");
                        break;
                    case 6:
                        bank.inactivarCuentas();
                        break;
                    case 7:
                        System.out.println("Ingrese Fecha Min Y/M/D ");
                        Calendar c = Calendar.getInstance();
                        c.set(lea.nextInt(), lea.nextInt()-1, lea.nextInt());
                        System.out.println("Ingrese cod cuenta: ");
                        bank.libreta(lea.nextInt(), c.getTime());
                        break;
                    case 8:
                        bank.registrarIntereses();
                        break;
                    case 9:
                        System.out.println("Ingrese archivo de txt: ");
                        bank.exportarCuentas(lea.next());
                        
                }
            }
            catch(Exception e)
            {
                System.out.println("Error: " + e.getMessage());
            }   
            
        }while( op != 10);
        
    }
}
