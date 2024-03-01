/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| dilan.calvache@epn.edu.ec  Msetoo      |
|----------------------------------------|
Autor : Mateo Calvache
Fecha : 29.02.2k24
*/
package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.CuentaAdminDTO;
import Framework.AppException; 

public class CuentaAdminDAO extends SQLiteDataHelper {

    public CuentaAdminDTO readByCorreo(String correo) throws Exception {
        CuentaAdminDTO cuenta = null;
        String query = "SELECT * FROM CuentaAdmin WHERE Correo = ?";
        Connection conn = openConnection();
        try (
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, correo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cuenta = new CuentaAdminDTO(rs.getString("Correo"), rs.getString("Password"));
            }
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readByCorreo()");
        }
        return cuenta;
    }

    public List<CuentaAdminDTO> readAll() throws Exception {
        List<CuentaAdminDTO> cuentas = new ArrayList<>();
        String query = "SELECT * FROM CuentaAdmin";
        try (Connection conn = openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                CuentaAdminDTO cuenta = new CuentaAdminDTO(rs.getString("Correo"), rs.getString("Password"));
                cuentas.add(cuenta);
            }
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return cuentas;
    }

    public boolean create(CuentaAdminDTO cuenta) throws Exception {
        String query = "INSERT INTO CuentaAdmin (Correo, Password) VALUES (?, ?)";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, cuenta.getCorreo());
            pstmt.setString(2, cuenta.getPassword());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    public boolean update(CuentaAdminDTO cuenta) throws Exception {
        String query = "UPDATE CuentaAdmin SET Password = ? WHERE Correo = ?";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, cuenta.getPassword());
            pstmt.setString(2, cuenta.getCorreo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    public boolean delete(String correo) throws Exception {
        String query = "DELETE FROM CuentaAdmin WHERE Correo = ?";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, correo);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "delete()");
        }
    }
}
