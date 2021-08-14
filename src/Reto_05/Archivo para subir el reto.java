import java.util.ArrayList;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class ControladorRequerimientosReto4 {       

    private final Consulta1_19Dao consulta1_19Dao;
    private final Consulta2_19Dao consulta2_19Dao;
    private final Consulta3_19Dao consulta3_19Dao;

    public ControladorRequerimientosReto4() {
        consulta1_19Dao = new Consulta1_19Dao();
        consulta2_19Dao = new Consulta2_19Dao();
        consulta3_19Dao = new Consulta3_19Dao();
    }

    public ArrayList<Consulta1VO_19> realizarConsulta1() throws SQLException{
        return this.consulta1_19Dao.consulta1DAO();
    }    

    public ArrayList<Consulta2VO_19> realizarConsulta2()throws SQLException{
        return this.consulta2_19Dao.consulta2DAO();
    }

    public ArrayList<Consulta3VO_19> realizarConsulta3() throws SQLException{
        return this.consulta3_19Dao.consulta3DAO();
    }
}


///////////////////////////////////////////////////////
public class Consulta1_19Dao {

    
    public ArrayList<Consulta1VO_19> consulta1DAO() throws SQLException 
    {
        ArrayList<Consulta1VO_19>  response = new ArrayList<Consulta1VO_19>();
        Connection connection = JDBCUtilities.getConnection();
        try 
        {
            PreparedStatement statement = connection.prepareStatement("SELECT ID_Proyecto, Fecha_Inicio, Constructora, Serial FROM Proyecto WHERE ID_Proyecto < 15");
            ResultSet rset = statement.executeQuery();

            while (rset.next()) {
                Consulta1VO_19 consulta1vo_19 = new Consulta1VO_19();
                consulta1vo_19.setId(rset.getInt("ID_Proyecto"));
                consulta1vo_19.setFecha(rset.getString("Fecha_Inicio"));
                consulta1vo_19.setConstructora(rset.getString("Constructora"));
                consulta1vo_19.setSerial(rset.getString("Serial"));
                response.add(consulta1vo_19);
            }
            rset.close();
            statement.close();

        }
        catch(SQLException e)
        {
            System.err.println("Error consultando ranking de bancos según el área promedio de proyectos respaldados: "+e);
        }
        finally
        {
            if(connection != null){
                connection.close();
            }
        }
        return response;        
    }  
}
///////////////////////////////////////////////////////////////////////
public class Consulta2_19Dao {

    public ArrayList<Consulta2VO_19> consulta2DAO() throws SQLException {

        ArrayList<Consulta2VO_19> response = new ArrayList<Consulta2VO_19>();
        Connection connection = JDBCUtilities.getConnection();
        String query = "SELECT Proyecto.ID_Proyecto,  Tipo.Area_Max FROM Proyecto INNER JOIN Tipo ON Proyecto.ID_Tipo = Tipo.ID_Tipo WHERE Proyecto.Numero_Habitaciones = 2";
        try {
            
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                //Se hace el mapeo de la entidad
                Consulta2VO_19 consulta2vo_19 = new Consulta2VO_19(
                    resultSet.getInt("ID_Proyecto"),
                    resultSet.getInt("Area_Max")
                );
                response.add(consulta2vo_19);
            }

            resultSet.close();
            statement.close();            
        } catch (SQLException e) {
            System.err.println("Error consultando ranking de bancos según el área promedio de proyectos respaldados: "+e);
        }finally{
            if(!connection.isClosed()){
                connection.close();
            }
        }
        return response;       
    }  
}
/////////////////////////////////////////////////////////////////////////
public class Consulta3_19Dao {

    public ArrayList<Consulta3VO_19> consulta3DAO() throws SQLException {

        ArrayList<Consulta3VO_19> response  = new ArrayList<>();
        Connection connection = JDBCUtilities.getConnection();

        String query = "SELECT Proyecto.ID_Proyecto ,Lider.Nombre || ' ' || Lider.Primer_Apellido AS nombreapellido FROM Proyecto "+
        "INNER JOIN Lider ON Proyecto.ID_Lider == Lider.ID_Lider "+
        "WHERE Banco_Vinculado = 'Bancolombia'";
        try {
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();

             while(resultSet.next()){
                 Consulta3VO_19 consulta3vo_19 = new Consulta3VO_19(
                     resultSet.getInt("ID_Proyecto"),
                     resultSet.getString("nombreapellido")
                 );

                 response.add(consulta3vo_19);
             }

             resultSet.close();
             statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultando ranking de bancos según el área promedio de proyectos respaldados: "+e);

        }finally {
            
            if(!connection.isClosed()){
                connection.close();
            }
        }
        return response;

       
    }  
}
/////////////////////////////////////////////////////////////////////////////////////////////////////
public class Consulta1VO_19 {
    
    private Integer iD_Proyecto;
    private String fecha_Inicio;
    private String constructora;
    private String serial;

    public Consulta1VO_19(){

    }

    public Consulta1VO_19(Integer id
    , String fecha
    , String constructora
    , String serial){
        this.iD_Proyecto = id;
        this.fecha_Inicio = fecha;
        this.constructora = constructora;
        this.serial = serial;

    }

    public void setId( Integer id){
        this.iD_Proyecto = id;
    }

    public void setFecha(String fecha){
        this.fecha_Inicio = fecha;
    }

    public void setConstructora(String constructora){
        this.constructora = constructora;
    }

    public void setSerial(String  serial){
        this.serial = serial;
    }

    public Integer getId(){return this.iD_Proyecto;}

    public String getFecha(){return this.fecha_Inicio;}

    public String getConstructora(){return this.constructora;}

    public String getSerial(){return this.serial;}
}
////////////////////////////////////////////////////////////////////////////////
public class Consulta2VO_19 {
    
    private Integer idProyecto;
    private Integer areaMaxima;

    public Consulta2VO_19(){}

    public Consulta2VO_19(Integer idProyecto, Integer areaMaxima){
        this.idProyecto = idProyecto;
        this.areaMaxima = areaMaxima;
    }

    public void setIdProyecto(Integer idProyecto){
        this.idProyecto = idProyecto;
    }

    public void setAreaMaxima(Integer areaMaxima){
        this.areaMaxima =  areaMaxima;
    }

    public Integer getIdProeycto(){
        return this.idProyecto;
    }
    public Integer getAreaMaxima(){
        return this.areaMaxima;
    }
}
////////////////////////////////////////////////////////////////////////////////////
public class Consulta3VO_19 {

    private Integer idProyecto;
    private String nombreApellido;

    public Consulta3VO_19(){}

    public Consulta3VO_19(Integer idProyecto, String nombreApellido){
        this.idProyecto = idProyecto;
        this.nombreApellido = nombreApellido;
    }

    public void setIdProyecto(Integer idProyecto){
        this.idProyecto = idProyecto;
    }

    public void setNombreApellido(String nombreApellido){
        this.nombreApellido = nombreApellido;
    }

    public Integer getIdProyecto(){return this.idProyecto;  }

    public String getNombreAppellido(){return this.nombreApellido; }
}
///////////////////////////////////////////////////////////////////////////////////
public class JDBCUtilities {
 private static final String UBICACION_BD = "ProyectosConstruccion.db"; 
 public static Connection getConnection() throws SQLException {
 String url = "jdbc:sqlite:" + UBICACION_BD;
 return DriverManager.getConnection(url);
 }
 public static boolean estaVacia(){
 File archivo = new File(JDBCUtilities.UBICACION_BD);
 // //Salida de diagnóstixo
 // System.out.println("UBICACION -> "+ JDBCUtilities.UBICACION_BD);
 // System.out.println("Longitud -> "+ archivo.length());
 return archivo.length() == 0;
 }
}