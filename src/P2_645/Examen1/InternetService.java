/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Examen1;

/**
 *
 * @author Gotcha
 */
public class InternetService extends Servicio{
    private int anchoBanda;
    
    public static int AB_256 = 256;
    public static int AB_512 = 512;
    public static int AB_1 = 1;
    public static int AB_2 = 2;
    
    public InternetService(int c, String n, int ab){
        super( c , n);
        anchoBanda = ab;
    }
    
    @Override
    public void imprimir(){
        super.imprimir();
        System.out.println("Ancho de banda de: " + anchoBanda);
    }
    
    @Override
    public double getMontoMensual(){
        if( anchoBanda == AB_256 ){
            return 150;
        }
        else if( anchoBanda == AB_512 )
            return 300;
        else if( anchoBanda == AB_1 )
            return 600;
        else if( anchoBanda == AB_2)
            return 1000;
        else
            return 0;
    }
}
