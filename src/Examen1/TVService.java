/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen1;

/**
 *
 * @author Gotcha
 */
public class TVService extends Servicio{
    private String canales[];
    private boolean isDigital;
    
    public TVService(int c,String n,int cant,boolean id){
        super(c,n);
        canales = new String[cant];
        isDigital = id;
    }
    
    public boolean buscar(String canal,int pos){
        if( pos < canales.length ){
            if( canal.equals( canales[pos] ) )
                return true;
            return buscar(canal, pos + 1);
        }
        return false;
    }
    
    @Override
    public double getMontoMensual(){
        monto = isDigital ? 5 : 0;
        monto += canales.length * 5;
        return monto;
    }
    
    @Override
    public void imprimir(){
        super.imprimir();
        for( String c : canales)
            System.out.printf("%s\n",c);
        System.out.println(isDigital ? " - Digital" : " - Normal");
    }
}
