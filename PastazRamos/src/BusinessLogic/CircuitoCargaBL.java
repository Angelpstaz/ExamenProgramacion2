package BusinessLogic;

import java.util.List;

import DataAccess.CircuitoCargaDAO;
import DataAccess.DTO.CircuitoCargaDTO;

public class CircuitoCargaBL {
    private CircuitoCargaDAO circuitoCargaDAO;

    public CircuitoCargaBL() {
        this.circuitoCargaDAO = new CircuitoCargaDAO();
    }

    public boolean create(CircuitoCargaDTO circuitoCargaDTO) throws Exception {
        return circuitoCargaDAO.create(circuitoCargaDTO);
    }

    public List<CircuitoCargaDTO> readAll() throws Exception {
        return circuitoCargaDAO.readAll();
    }

    public CircuitoCargaDTO readBy(int id) throws Exception {
        return circuitoCargaDAO.readBy(id);
    }

    public boolean update(CircuitoCargaDTO circuitoCargaDTO) throws Exception {
        return circuitoCargaDAO.update(circuitoCargaDTO);
    }

    public boolean delete(int id) throws Exception {
        return circuitoCargaDAO.delete(id);
    }
}
