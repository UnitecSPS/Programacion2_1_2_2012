/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Interfaces;

/**
 *
 * @author Gotcha
 */
public final class ArregloCadenas implements Arreglo {

    private String cadenas[];
    private int contador = 0;
    
    public ArregloCadenas(){
        cadenas = new String[ Arreglo.MAX_VALUE ];
    }
    
    @Override
    public void agregarElemento(Object obj) {
        if( contador < cadenas.length )
            if( obj instanceof String ){
                cadenas[contador++] = obj.toString();
            }
    }

    @Override
    public Object sacarElemento(int index) {
        return cadenas[ index ];
    }

    @Override
    public void imprimir() {
        for(int c=0; c < contador ; c++)
            System.out.println(cadenas[c]);
    }
    
}
