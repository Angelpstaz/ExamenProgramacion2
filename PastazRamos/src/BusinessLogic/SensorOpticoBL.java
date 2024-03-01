package BusinessLogic;

import java.util.List;

import DataAccess.SensorOpticoDAO;
import DataAccess.DTO.SensorOpticoDTO;

public class SensorOpticoBL {
    private SensorOpticoDAO sensorOpticoDAO;

    public SensorOpticoBL() {
        this.sensorOpticoDAO = new SensorOpticoDAO();
    }

    public boolean create(SensorOpticoDTO sensorOpticoDTO) throws Exception {
        return sensorOpticoDAO.create(sensorOpticoDTO);
    }

    public List<SensorOpticoDTO> readAll() throws Exception {
        return sensorOpticoDAO.readAll();
    }

    public SensorOpticoDTO readBy(int id) throws Exception {
        return sensorOpticoDAO.readBy(id);
    }

    public boolean update(SensorOpticoDTO sensorOpticoDTO) throws Exception {
        return sensorOpticoDAO.update(sensorOpticoDTO);
    }

    public boolean delete(int id) throws Exception {
        return sensorOpticoDAO.delete(id);
    }
}

