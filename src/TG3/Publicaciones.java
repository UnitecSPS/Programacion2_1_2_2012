package TG3;

import java.io.IOException;
import java.util.Scanner;

public class Publicaciones {
    public static void main(String args[]){
        CMS cms = new CMS();
        Scanner sc = new Scanner(System.in);
        //sc.useDelimiter(System.getProperty("line.separator"));
        int R = 0;
        do{
            try {
                System.out.println("\n1. Agregar Autor");
                System.out.println("2. Crear Articulo");
                System.out.println("3. Blog");
                System.out.println("4. Leer Articulo");
                System.out.println("5. Salir");
                System.out.println("   Seleccion: ");
                R = sc.nextInt();
                switch(R){
                    case 1:
                        int c;
                        System.out.println("Codigo del Autor: ");
                        c = sc.nextInt();
                        System.out.println("Nombre del Autor: ");
                        if( cms.agregarAutor(c, sc.next()) )
                            System.out.println("Agregado con Exito");
                        else
                            System.out.println("Fallo Agregar Autor");
                        break;
                    case 2:
                        System.out.println("Titulo del Articulo: ");
                        String titulo = sc.next();
                        System.out.println("Contenido");
                        String contenido = sc.next();
                        if( cms.crearArticulo(titulo, contenido) )
                            System.out.println("Articulo creado con Exito");
                        else
                            System.out.println("No se pudo Crear");
                        break;
                    case 3:
                        cms.blog();
                        break;
                    case 4:
                        System.out.println("Codigo del Articulo: ");
                        cms.leerArticulo(sc.nextInt());
                }
            } catch (IOException ex) {
                System.out.println("Error. "+ex.getMessage());
            }
        }while(R!=5);
    }
}
