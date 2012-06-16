/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab3;

/**
 *
 * @author Gotcha
 */
public enum TipoEsquela {
    LEVE(200),MEDIANA(500), GRAVE(900);
    public double multa;
    
    TipoEsquela(double m){
        multa = m;
    }
}
