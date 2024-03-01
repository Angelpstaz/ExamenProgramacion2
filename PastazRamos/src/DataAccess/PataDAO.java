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

import DataAccess.DTO.PataDTO;
import Framework.AppException;

public class PataDAO extends SQLiteDataHelper implements IDAO<PataDTO> {
    @Override
    public PataDTO readBy(Integer id) throws Exception {
        PataDTO pata = new PataDTO();
        String query = " SELECT idPata, nombre, numeroPatas, Estado, Observacion, FechaCrea, FechaModifica " 
                     + " FROM Pata "
                     + " WHERE Estado ='A' AND idPata = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                pata = new PataDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return pata;
    }

    @Override
    public List<PataDTO> readAll() throws Exception {
        List<PataDTO> list = new ArrayList<>();
        String query = " SELECT idPata, nombre, numeroPatas, Estado, Observacion, FechaCrea, FechaModifica " 
                     + " FROM Pata "
                     + " WHERE Estado ='A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PataDTO pata = new PataDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(pata);
            }
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return list;
    }

    @Override
    public boolean create(PataDTO entity) throws Exception {
        String query = " INSERT INTO Pata (nombre, numeroPatas, Observacion) VALUES (?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getNumeroPatas());
            pstmt.setString(3, entity.getObservacion());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(PataDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Pata SET nombre = ?, numeroPatas = ?, Observacion = ?, FechaModifica = ? WHERE idPata = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getNumeroPatas());
            pstmt.setString(3, entity.getObservacion());
            pstmt.setString(4, dtf.format(now).toString());
            pstmt.setInt(5, entity.getIdPata());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Pata SET Estado = 'X' WHERE idPata = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*) TotalReg FROM Pata "
                     + " WHERE Estado ='A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }

    public boolean crear(PataDTO pataDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    public List<PataDTO> leerTodo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leerTodo'");
    }

    public PataDTO leerPor(Integer idPata) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leerPor'");
    }

    public boolean actualizar(PataDTO pataDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    public boolean eliminar(Integer idPata) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
}
