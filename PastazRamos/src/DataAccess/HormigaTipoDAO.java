/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| pdavila0113@gmail.com      BaphomeT-T  |
|----------------------------------------|
Autor : BaphomeT-T
Fecha : 25.feb.2k24
*/
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

import DataAccess.DTO.HormigaTipoDTO;
import Framework.AppException;

public class HormigaTipoDAO extends SQLiteDataHelper implements IDAO<HormigaTipoDTO>{
    @Override
    public HormigaTipoDTO readBy(Integer id) throws Exception {
        HormigaTipoDTO oS = new HormigaTipoDTO();
        String query =" SELECT IdHormigaTipo  " 
                     +" ,Nombre        " 
                     +" ,Estado        " 
                     +" ,FechaCrea     " 
                     +" ,FechaModifica "
                     +" FROM    HormigaTipo   "
                     +" WHERE   Estado ='A' AND IdHormigaTipo =   "+ id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oS = new HormigaTipoDTO(rs.getInt(1)           // IdHormigaTipo
                                ,rs.getString(2)        // Nombre             
                                ,rs.getString(3)        // Estado         
                                ,rs.getString(4)        // FechaCrea      
                                ,rs.getString(5));      // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<HormigaTipoDTO> readAll() throws Exception {
        List <HormigaTipoDTO> lst = new ArrayList<>();
        String query =" SELECT IdHormigaTipo  " 
                     +" ,Nombre        " 
                     +" ,Estado        " 
                     +" ,FechaCrea     " 
                     +" ,FechaModifica "
                     +" FROM    HormigaTipo   "
                     +" WHERE   Estado ='A' ";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                HormigaTipoDTO s = new HormigaTipoDTO( rs.getInt(1)     // IdHormigaTipo
                                        ,rs.getString(2)  // Nombre             
                                        ,rs.getString(3)  // Estado         
                                        ,rs.getString(4)  // FechaCrea      
                                        ,rs.getString(5));// FechaModifica
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(HormigaTipoDTO entity) throws Exception {
        String query = " INSERT INTO HormigaTipo (Nombre) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(HormigaTipoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE HormigaTipo SET Nombre = ?, FechaModifica = ? WHERE IdHormigaTipo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdHormigaTipo());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE HormigaTipo SET Estado = ? WHERE IdHormigaTipo = ?";
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
        String query =" SELECT COUNT(*) TotalReg FROM HormigaTipo "
                     +" WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}

