package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.RadioDTO;
import Framework.AppException;

import DataAccess.DTO.RegistroHormigasDTO;
import Framework.AppException;

public class RegistroHormigasDAO extends SQLiteDataHelper implements IDAO<RegistroHormigasDTO> {

    @Override
    public RegistroHormigasDTO readBy(Integer id) throws Exception {
        RegistroHormigasDTO oS = new RegistroHormigasDTO();
        String query =" SELECT * FROM RegistroHormigas WHERE Estado ='A' AND IdRegistroHormigas = "+ id.toString() ;
        try {
            Connection conn = openConnection();         
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                oS = new RegistroHormigasDTO(rs.getInt(1)
                                            ,rs.getInt(2)
                                            ,rs.getInt(3)
                                            ,rs.getString(4)
                                            ,rs.getString(5)
                                            ,rs.getString(6)
                                            ,rs.getString(7)
                                            ,rs.getString(8)
                                            ,rs.getString(9));
            }
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
public List<RegistroHormigasDTO> readAll() throws Exception {
    List<RegistroHormigasDTO> lst = new ArrayList<>();
    String query =" SELECT * FROM RegistroHormigas WHERE Estado ='A' ";
    try {
        Connection conn = openConnection();         
        Statement  stmt = conn.createStatement();   
        ResultSet rs   = stmt.executeQuery(query);  
        while (rs.next()) {
            RegistroHormigasDTO s = new RegistroHormigasDTO( rs.getInt(1)
                                                            ,rs.getInt(2)
                                                            ,rs.getInt(3)
                                                            ,rs.getString(4)
                                                            ,rs.getString(5)
                                                            ,rs.getString(6)
                                                            ,rs.getString(7)
                                                            ,rs.getString(8)
                                                            ,rs.getString(9));
            lst.add(s);
        }
    } 
    catch (SQLException e) {
        throw new AppException(e.getMessage(), getClass().getName(), "readAll()");
    }
    return lst; 
}

@Override
public boolean create(RegistroHormigasDTO entity) throws Exception {
    String query = " INSERT INTO RegistroHormigas (IdHormiga, idHormigaTipo, Comió, Recogió, Observacion) VALUES (?, ?, ?, ?, ?)";
    try {
        Connection        conn  = openConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, entity.getIdHormiga());
        pstmt.setInt(2, entity.getIdHormigaTipo());
        pstmt.setString(3, entity.getComio());
        pstmt.setString(4, entity.getRecogio());
        pstmt.setString(5, entity.getObservacion());
        pstmt.executeUpdate();
        return true;
    } 
    catch (SQLException e) {
        throw new AppException(e.getMessage(), getClass().getName(), "create()");
    }
}

@Override
public boolean update(RegistroHormigasDTO entity) throws Exception {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();
    String query = " UPDATE RegistroHormigas SET IdHormiga = ?, idHormigaTipo = ?, Comió = ?, Recogió = ?, Observacion = ?, FechaModifica = ? WHERE IdRegistroHormigas = ?";
    try {
        Connection          conn = openConnection();
        PreparedStatement pstmt  = conn.prepareStatement(query);
        pstmt.setInt(1, entity.getIdHormiga());
        pstmt.setInt(2, entity.getIdHormigaTipo());
        pstmt.setString(3, entity.getComio());
        pstmt.setString(4, entity.getRecogio());
        pstmt.setString(5, entity.getObservacion());
        pstmt.setString(6, dtf.format(now).toString());
        pstmt.setInt(7, entity.getIdRegistroHormigas());
        pstmt.executeUpdate();
        return true;
    } 
    catch (SQLException e) {
        throw new AppException(e.getMessage(), getClass().getName(), "update()");
    }
}

@Override
public boolean delete(Integer id) throws Exception {
    String query = " UPDATE RegistroHormigas SET Estado = ? WHERE IdRegistroHormigas = ?";
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
    String query =" SELECT COUNT(*) TotalReg FROM RegistroHormigas WHERE Estado ='A' ";
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
