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

import DataAccess.DTO.AntenaDTO;
import Framework.AppException;

public class AntenaDAO extends SQLiteDataHelper implements IDAO<AntenaDTO>{

    @Override
    public AntenaDTO readBy(Integer id) throws Exception {
        AntenaDTO oS = new AntenaDTO();
        String query =" SELECT idAntena, nombre, Estado, Observacion, FechaCrea, FechaModifica " 
                     +" FROM Antena "
                     +" WHERE Estado ='A' AND idAntena = "+ id.toString() ;
        try {
            Connection conn = openConnection();         
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                oS = new AntenaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<AntenaDTO> readAll() throws Exception {
        List <AntenaDTO> lst = new ArrayList<>();
        String query =" SELECT idAntena, nombre, Estado, Observacion, FechaCrea, FechaModifica " 
                     +" FROM Antena "
                     +" WHERE Estado ='A' ";

        try {
            Connection conn = openConnection();         
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                AntenaDTO s = new AntenaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(AntenaDTO entity) throws Exception {
        String query = " INSERT INTO Antena (nombre, Observacion) VALUES (?, ?)";
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
    public boolean update(AntenaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Antena SET nombre = ?, Observacion = ?, FechaModifica = ? WHERE idAntena = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getObservacion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdAntena());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Antena SET Estado = ? WHERE idAntena = ?";
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
        String query =" SELECT COUNT(*) TotalReg FROM Antena "
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
