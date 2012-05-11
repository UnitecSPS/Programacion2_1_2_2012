/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Interfaces;

/**
 *
 * @author Gotcha
 */
public interface SmartPhone {
    int serialID = 123456;
    
    boolean mandarMMS(int numTel,String msg);
    void browser(String url);
    void agregarAPP(String app);
    String[] listaAPP();
}
