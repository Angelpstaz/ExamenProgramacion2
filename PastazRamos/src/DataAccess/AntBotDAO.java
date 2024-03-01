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

import DataAccess.DTO.AntBotDTO;
import Framework.AppException;

public class AntBotDAO extends SQLiteDataHelper implements IDAO<AntBotDTO>{

    @Override
    public AntBotDTO readBy(Integer id) throws Exception {
        AntBotDTO antBot = new AntBotDTO();
        String query = "SELECT idAntBot, idIABot, idHormiga, idAla, idProcesador, idCircuitoAnillado, idTenaza, idRadio, idSensorOptico, " +
                       "idAntena, idCamara, idCircuitoCarga, idPata, idFuentePoder, idExpertoIdiomas, Estado, Observacion, FechaCrea, FechaModifica " +
                       "FROM AntBot WHERE Estado ='A' AND idAntBot = " + id.toString();

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                antBot = new AntBotDTO(rs.getInt("idAntBot"), rs.getInt("idIABot"), rs.getInt("idHormiga"), rs.getInt("idAla"),
                                       rs.getInt("idProcesador"), rs.getInt("idCircuitoAnillado"), rs.getInt("idTenaza"),
                                       rs.getInt("idRadio"), rs.getInt("idSensorOptico"), rs.getInt("idAntena"),
                                       rs.getInt("idCamara"), rs.getInt("idCircuitoCarga"), rs.getInt("idPata"),
                                       rs.getInt("idFuentePoder"), rs.getInt("idExpertoIdiomas"), rs.getString("Estado"),
                                       rs.getString("Observacion"), rs.getString("FechaCrea"), rs.getString("FechaModifica"));
            }
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readBy()");
        }

        return antBot;
    }

    @Override
    public List<AntBotDTO> readAll() throws Exception {
        List<AntBotDTO> antBotList = new ArrayList<>();
        String query = "SELECT idAntBot, idIABot, idHormiga, idAla, idProcesador, idCircuitoAnillado, idTenaza, idRadio, idSensorOptico, " +
                       "idAntena, idCamara, idCircuitoCarga, idPata, idFuentePoder, idExpertoIdiomas, Estado, Observacion, FechaCrea, FechaModifica " +
                       "FROM AntBot WHERE Estado ='A'";

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                AntBotDTO antBot = new AntBotDTO(rs.getInt("idAntBot"), rs.getInt("idIABot"), rs.getInt("idHormiga"), rs.getInt("idAla"),
                                                rs.getInt("idProcesador"), rs.getInt("idCircuitoAnillado"), rs.getInt("idTenaza"),
                                                rs.getInt("idRadio"), rs.getInt("idSensorOptico"), rs.getInt("idAntena"),
                                                rs.getInt("idCamara"), rs.getInt("idCircuitoCarga"), rs.getInt("idPata"),
                                                rs.getInt("idFuentePoder"), rs.getInt("idExpertoIdiomas"), rs.getString("Estado"),
                                                rs.getString("Observacion"), rs.getString("FechaCrea"), rs.getString("FechaModifica"));
                antBotList.add(antBot);
            }
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "readAll()");
        }

        return antBotList;
    }

    @Override
    public boolean create(AntBotDTO entity) throws Exception {
        String query = "INSERT INTO AntBot (idIABot, idHormiga, idAla, idProcesador, idCircuitoAnillado, idTenaza, idRadio, " +
                       "idSensorOptico, idAntena, idCamara, idCircuitoCarga, idPata, idFuentePoder, idExpertoIdiomas, Estado, " +
                       "Observacion, FechaCrea, FechaModifica) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, entity.getIdIABot());
            pstmt.setInt(2, entity.getIdHormiga());
            pstmt.setInt(3, entity.getIdAla());
            pstmt.setInt(4, entity.getIdProcesador());
            pstmt.setInt(5, entity.getIdCircuitoAnillado());
            pstmt.setInt(6, entity.getIdTenaza());
            pstmt.setInt(7, entity.getIdRadio());
            pstmt.setInt(8, entity.getIdSensorOptico());
            pstmt.setInt(9, entity.getIdAntena());
            pstmt.setInt(10, entity.getIdCamara());
            pstmt.setInt(11, entity.getIdCircuitoCarga());
            pstmt.setInt(12, entity.getIdPata());
            pstmt.setInt(13, entity.getIdFuentePoder());
            pstmt.setInt(14, entity.getIdExpertoIdiomas());
            pstmt.setString(15, entity.getEstado());
            pstmt.setString(16, entity.getObservacion());
            pstmt.setString(17, entity.getFechaCrea());
            pstmt.setString(18, entity.getFechaModifica());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(AntBotDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE AntBot SET idIABot = ?, idHormiga = ?, idAla = ?, idProcesador = ?, idCircuitoAnillado = ?, " +
                       "idTenaza = ?, idRadio = ?, idSensorOptico = ?, idAntena = ?, idCamara = ?, idCircuitoCarga = ?, " +
                       "idPata = ?, idFuentePoder = ?, idExpertoIdiomas = ?, Estado = ?, Observacion = ?, " +
                       "FechaModifica = ? WHERE idAntBot = ?";

        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, entity.getIdIABot());
            pstmt.setInt(2, entity.getIdHormiga());
            pstmt.setInt(3, entity.getIdAla());
            pstmt.setInt(4, entity.getIdProcesador());
            pstmt.setInt(5, entity.getIdCircuitoAnillado());
            pstmt.setInt(6, entity.getIdTenaza());
            pstmt.setInt(7, entity.getIdRadio());
            pstmt.setInt(8, entity.getIdSensorOptico());
            pstmt.setInt(9, entity.getIdAntena());
            pstmt.setInt(10, entity.getIdCamara());
            pstmt.setInt(11, entity.getIdCircuitoCarga());
            pstmt.setInt(12, entity.getIdPata());
            pstmt.setInt(13, entity.getIdFuentePoder());
            pstmt.setInt(14, entity.getIdExpertoIdiomas());
            pstmt.setString(15, entity.getEstado());
            pstmt.setString(16, entity.getObservacion());
            pstmt.setString(17, dtf.format(now).toString());
            pstmt.setInt(18, entity.getIdAntBot());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE AntBot SET Estado = 'X' WHERE idAntBot = ?";

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
        String query = "SELECT COUNT(*) TotalReg FROM AntBot WHERE Estado ='A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                return rs.getInt("TotalReg");
            }
        } catch (SQLException e) {
            throw new AppException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }

        return 0;
    }
}
