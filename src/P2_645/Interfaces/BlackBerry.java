/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Interfaces;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class BlackBerry implements SmartPhone {
    public int num;
    public ArrayList<String> amigosPins;
    
    public BlackBerry(int n){
        num = n;
        amigosPins = new ArrayList<String>();
    }

    @Override
    public boolean mandarMMS(int numTel, String msg) {
        System.out.println("MANDAR");
        return true;
    }

    @Override
    public void browser(String url) {
        System.out.println("PAGE NOT FOUND 404");
    }

    @Override
    public void agregarAPP(String app) {
        System.out.println("NO WORKING");
    }

    @Override
    public String[] listaAPP() {
        String apps[] = {"BBMSN","Facebook","Twitter","Foursquare"};
        return apps;
    }
    
    
}
