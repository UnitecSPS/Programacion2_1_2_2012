/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Archivos;

/**
 *
 * @author Gotcha
 */
public enum TipoGenero{ POP, ROCK, RAP, COUNTRY;

    //HOME MADE
    public static TipoGenero porOrdinal(int ordinal){
        switch( ordinal ){
            case 0:
                return TipoGenero.POP;
            case 1:
                return TipoGenero.ROCK;
            case 2:
                return TipoGenero.RAP;
            case 3:
                return TipoGenero.COUNTRY;
        }
        throw new RuntimeException("Genero incorrecto");
    }
}
