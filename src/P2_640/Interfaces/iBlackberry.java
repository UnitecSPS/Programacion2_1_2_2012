/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Interfaces;

import java.util.ArrayList;

/**
 *
 * @author CarlosArmando
 */
public interface iBlackberry {
    int bb_serial = 77;
    ArrayList<Object> lista = new ArrayList<Object>();
    
    void agregarAmigo(int pin);
    int cuantosAmigos();
}
