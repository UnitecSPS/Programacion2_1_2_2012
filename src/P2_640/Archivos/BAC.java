/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Archivos;

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
                System.out.println("4- Salir");
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
                        
                }
            }
            catch(Exception e)
            {
                System.out.println("Error: " + e.getMessage());
            }   
            
        }while( op != 4);
        
    }
}
