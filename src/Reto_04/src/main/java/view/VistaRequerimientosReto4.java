package view;

import controller.ControladorRequerimientosReto4;
import model.vo.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class VistaRequerimientosReto4 {
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();


    public static void consulta1(){
        System.out.println("-----Consulta 1-------"); 
        try{

            ArrayList<Consulta1VO_19> lista = controlador.realizarConsulta1();
            
            //Encabezado del resultado
            System.out.println("id_proyecto, Fecha_Inicio , Constructora , serial");
            
            //Cada VO cargado, mostrarlo en la vista
            for (Consulta1VO_19 item : lista) {
                System.out.printf("%d %s %s %s", 
                item.getId(), 
                item.getFecha(), 
                item.getConstructora(), 
                item.getSerial()
                );   
                System.out.println();
            }
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
       }      
    }

    public static void consulta2(){
        System.out.println("-----Consulta 2-------"); 
        try{

            ArrayList<Consulta2VO_19> lista = controlador.realizarConsulta2();

            //Encabezado del resultado
            System.out.println("id_proyecto, area_max");
            //Cada VO cargado, mostrarlo en la vista
            for(Consulta2VO_19 item : lista)
            {
                System.out.printf("%d %d", item.getIdProeycto(),item.getAreaMaxima());
                System.out.println();
            }
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }      
    }


    public static void consulta3(){
        System.out.println("-----Consulta 3-------"); 
        try{

            ArrayList<Consulta3VO_19> lista = controlador.realizarConsulta3();

            //Encabezado del resultado
            System.out.println("id_proyecto, nombreapellido");

            for(Consulta3VO_19 item : lista)
            {
                System.out.printf("%d %s"
                , item.getIdProyecto()
                , item.getNombreAppellido()
                );
                System.out.println();
            }
            
            //Cada VO cargado, mostrarlo en la vista
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }      
    }
}
