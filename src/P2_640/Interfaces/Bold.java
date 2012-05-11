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
public class Bold extends Phone implements iBlackberry, iSmartPhone{
 
    private ArrayList<Integer> amiguis;
    
    public Bold(int n){
        super(n);
        amiguis = new ArrayList<Integer>();
    }

    @Override
    public void imprimir() {
        System.out.println("numero: " + numero);
        for(Integer i : amiguis)
            System.out.println("amigos pin: " + i);
    }

    @Override
    public void agregarAmigo(int pin) {
        amiguis.add(pin);
    }

    @Override
    public int cuantosAmigos() {
        return amiguis.size();
                
    }

    @Override
    public boolean navegar(String url) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void agregarAplicacion(String app) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
