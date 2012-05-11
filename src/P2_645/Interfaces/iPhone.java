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
public class iPhone extends Phone implements SmartPhone {

    private String userItunes;
    private ArrayList<String> apps;
    
    public iPhone(int num){
        super(num);
        camara = true;
        apps = new ArrayList<String>();
    }
    
    @Override
    public boolean mandarMMS(int numTel, String msg) {
        if( msg.length() <= 140 ){
            System.out.println("Mandar MSG " + msg + 
                    " a " + numTel);
            return true;
        }
        System.out.println("MANDAR FALLO");
        return false;
    }

    @Override
    public void browser(String url) {
        System.out.println("http://" + url);
    }

    @Override
    public void agregarAPP(String app) {
        apps.add(app);
    }

    @Override
    public String[] listaAPP() {
        String arra[] = new String[ apps.size() ];
        return apps.toArray(arra);
    }
    
}
