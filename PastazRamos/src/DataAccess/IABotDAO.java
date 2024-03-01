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
import DataAccess.DTO.IABotDTO;
import Framework.AppException;

public class IABotDAO extends SQLiteDataHelper implements IDAO<IABotDTO> {
    @Override
    public IABotDTO readBy(Integer id) throws Exception {
        IABotDTO oS = new IABotDTO();
        String query =" SELECT idIABot, nombre, Estado, Observacion, FechaCrea, FechaModifica " 
                     +" FROM IABot "
                     +" WHERE Estado ='A' AND idIABot = " + id.toString();
        try {
            Connection conn = openConnection();         
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                oS = new IABotDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
public List<IABotDTO> readAll() throws Exception {
    List<IABotDTO> lst = new ArrayList<>();
    String query =" SELECT idIABot, nombre, Estado, Observacion, FechaCrea, FechaModifica " 
                 +" FROM IABot "
                 +" WHERE Estado ='A' ";
    try {
        Connection conn = openConnection();         
        Statement  stmt = conn.createStatement();   
        ResultSet rs   = stmt.executeQuery(query);  
        while (rs.next()) {
            IABotDTO s = new IABotDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            lst.add(s);
        }
    } 
    catch (SQLException e) {
        throw new AppException(e.getMessage(), getClass().getName(), "readAll()");
    }
    return lst; 
}

@Override
public boolean create(IABotDTO entity) throws Exception {
    String query = " INSERT INTO IABot (nombre, Observacion) VALUES (?, ?)";
    try {
        Connection conn = openConnection();
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
public boolean update(IABotDTO entity) throws Exception {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();
    String query = " UPDATE IABot SET nombre = ?, Observacion = ?, FechaModifica = ? WHERE idIABot = ?";
    try {
        Connection conn = openConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, entity.getNombre());
        pstmt.setString(2, entity.getObservacion());
        pstmt.setString(3, dtf.format(now).toString());
        pstmt.setInt(4, entity.getIdIABot());
        pstmt.executeUpdate();
        return true;
    } 
    catch (SQLException e) {
        throw new AppException(e.getMessage(), getClass().getName(), "update()");
    }
}

@Override
public boolean delete(Integer id) throws Exception {
    String query = " UPDATE IABot SET Estado = ? WHERE idIABot = ?";
    try {
        Connection conn = openConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
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
    String query =" SELECT COUNT(*) TotalReg FROM IABot "
                 +" WHERE Estado ='A' ";
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