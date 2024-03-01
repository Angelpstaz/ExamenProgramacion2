package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.SensorOpticoDTO;
import Framework.AppException;

public class SensorOpticoDAO extends SQLiteDataHelper implements IDAO<SensorOpticoDTO>{

    @Override
    public SensorOpticoDTO readBy(Integer id) throws Exception {
        SensorOpticoDTO oS = new SensorOpticoDTO();
        String query =" SELECT idSensorOptico, nombre, Estado, Observacion, FechaCrea, FechaModifica " 
                     +" FROM SensorOptico "
                     +" WHERE Estado ='A' AND idSensorOptico = "+ id.toString() ;
        try {
            Connection conn = openConnection();         
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                oS = new SensorOpticoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<SensorOpticoDTO> readAll() throws Exception {
        List <SensorOpticoDTO> lst = new ArrayList<>();
        String query =" SELECT idSensorOptico, nombre, Estado, Observacion, FechaCrea, FechaModifica " 
                     +" FROM SensorOptico "
                     +" WHERE Estado ='A' ";

        try {
            Connection conn = openConnection();         
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                SensorOpticoDTO s = new SensorOpticoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(SensorOpticoDTO entity) throws Exception {
        String query = " INSERT INTO SensorOptico (nombre, Observacion) VALUES (?, ?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getObservacion());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(SensorOpticoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE SensorOptico SET nombre = ?, Observacion = ?, FechaModifica = ? WHERE idSensorOptico = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getObservacion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdSensorOptico());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE SensorOptico SET Estado = ? WHERE idSensorOptico = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg FROM SensorOptico "
                     +" WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();         
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                return rs.getInt(1);                    
            }
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}
