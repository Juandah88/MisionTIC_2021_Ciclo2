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
