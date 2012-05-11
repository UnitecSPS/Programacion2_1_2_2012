/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Interfaces;

/**
 *
 * @author Gotcha
 */
public class Digicel {
    public static void main(String args[]){
        SmartPhone sp1 = new iPhone(9993);
        SmartPhone sp2 = new BlackBerry(67676);
        
        sp1.browser("portal.unitec.edu");
        sp2.browser("www.facebook.com");
    }
}
