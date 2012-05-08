package P2_640.ExamenLab1;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class DVD_Renta extends ITEMRenta {
    protected String genero;
    protected double duracion;
    protected String actores[];
    
    public DVD_Renta(int c, String n, double p, int cant,String g, double d){
        super(c,n,p,cant);
        genero=g;
        duracion=d;
        ingresarActores();
    }
    
    private void ingresarActores(){
        Scanner lea=new Scanner(System.in);
        System.out.println("CUANTOS ACTORES HAY: ");
        int canta=lea.nextInt();
        actores=new String[canta];
        
        for(int cont=0;cont<actores.length;cont++){
            System.out.println(cont+1 + ". Nombre actor/actriz: ");
            actores[cont]=lea.next();
        }
    }
    
    private void listarActores(int cont){
        if(cont<actores.length){
            System.out.println(actores[cont]);
            listarActores(cont+1);
        }
    }
    
    protected void listarActores(){
        listarActores(0);
    }

    @Override
    protected double getMontoRenta(int dias) {
        if(dias<=2){
            cantcopias-=1;
            return precio;
        }else{
            cantcopias-=1;
            return precio+(precio*0.8)*(dias-2);
        }
    }

    @Override
    protected void imprimir() {
        super.imprimir();
        System.out.println(" GENERO: "+genero+" DURACION: "+duracion+ "ELENCO:");
        listarActores();
    }  
}