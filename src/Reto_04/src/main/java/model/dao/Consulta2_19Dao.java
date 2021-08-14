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
