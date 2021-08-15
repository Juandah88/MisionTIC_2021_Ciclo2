package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.*;

public class Consulta1_19Dao {

    
    public ArrayList<Consulta1VO_19> consulta1DAO() throws SQLException 
    {
        ArrayList<Consulta1VO_19>  arrayConsulta1Vo = new ArrayList<Consulta1VO_19>();
        Connection connection = JDBCUtilities.getConnection();
        try 
        {
            PreparedStatement statement = connection.prepareStatement("SELECT ID_Proyecto, Fecha_Inicio, Constructora, Serial FROM Proyecto WHERE ID_Proyecto < 15");
            ResultSet rset = statement.executeQuery();

            while (rset.next()) {

                Consulta1VO_19 consulta1vo_19 = new Consulta1VO_19();
                consulta1vo_19.setIdProyecto(rset.getInt("ID_Proyecto"));
                consulta1vo_19.setFechaInicio(rset.getString("Fecha_Inicio"));
                consulta1vo_19.setConstructora(rset.getString("Constructora"));
                consulta1vo_19.setSerial(rset.getString("Serial"));

                arrayConsulta1Vo.add(consulta1vo_19);
            }
            rset.close();
            statement.close();

        }
        catch(SQLException e)
        {
            throw new SQLException("Error consultando ranking de bancos según el área promedio de proyectos respaldados: "+e);
        }
        finally
        {
            if(!connection.isClosed()){
                connection.close();
            }
        }
        return arrayConsulta1Vo;        
    }  
}
