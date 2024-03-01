package BusinessLogic;

import java.util.List;

import DataAccess.CircuitoAnilladoDAO;
import DataAccess.DTO.CircuitoAnilladoDTO;

public class CircuitoAnilladoBL {
    private CircuitoAnilladoDAO circuitoAnilladoDAO;

    public CircuitoAnilladoBL() {
        this.circuitoAnilladoDAO = new CircuitoAnilladoDAO();
    }

    public boolean create(CircuitoAnilladoDTO circuitoAnilladoDTO) throws Exception {
        return circuitoAnilladoDAO.create(circuitoAnilladoDTO);
    }

    public List<CircuitoAnilladoDTO> readAll() throws Exception {
        return circuitoAnilladoDAO.readAll();
    }

    public CircuitoAnilladoDTO readBy(int id) throws Exception {
        return circuitoAnilladoDAO.readBy(id);
    }

    public boolean update(CircuitoAnilladoDTO circuitoAnilladoDTO) throws Exception {
        return circuitoAnilladoDAO.update(circuitoAnilladoDTO);
    }

    public boolean delete(int id) throws Exception {
        return circuitoAnilladoDAO.delete(id);
    }
}
