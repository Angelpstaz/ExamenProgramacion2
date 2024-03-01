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
import DataAccess.DTO.CircuitoAnilladoDTO;
import Framework.AppException;

public class CircuitoAnilladoDAO extends SQLiteDataHelper implements IDAO<CircuitoAnilladoDTO>{

    @Override
    public CircuitoAnilladoDTO readBy(Integer id) throws Exception {
        CircuitoAnilladoDTO oS = new CircuitoAnilladoDTO();
        String query =" SELECT idCircuitoAnillado, nombre, Estado, Observacion, FechaCrea, FechaModifica " 
                     +" FROM CircuitoAnillado "
                     +" WHERE Estado ='A' AND idCircuitoAnillado = "+ id.toString() ;
        try {
            Connection conn = openConnection();         
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                oS = new CircuitoAnilladoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<CircuitoAnilladoDTO> readAll() throws Exception {
        List <CircuitoAnilladoDTO> lst = new ArrayList<>();
        String query =" SELECT idCircuitoAnillado, nombre, Estado, Observacion, FechaCrea, FechaModifica " 
                     +" FROM CircuitoAnillado "
                     +" WHERE Estado ='A' ";

        try {
            Connection conn = openConnection();         
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                CircuitoAnilladoDTO s = new CircuitoAnilladoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(CircuitoAnilladoDTO entity) throws Exception {
        String query = " INSERT INTO CircuitoAnillado (nombre, Observacion) VALUES (?, ?)";
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
    public boolean update(CircuitoAnilladoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE CircuitoAnillado SET nombre = ?, Observacion = ?, FechaModifica = ? WHERE idCircuitoAnillado = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getObservacion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdCircuitoAnillado());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE CircuitoAnillado SET Estado = ? WHERE idCircuitoAnillado = ?";
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
        String query =" SELECT COUNT(*) TotalReg FROM CircuitoAnillado "
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
