package BusinessLogic;

import java.util.List;

import DataAccess.ProcesadorDAO;
import DataAccess.DTO.ProcesadorDTO;

public class ProcesadorBL {
    private ProcesadorDAO procesadorDAO;

    public ProcesadorBL() {
        this.procesadorDAO = new ProcesadorDAO();
    }

    public boolean create(ProcesadorDTO procesadorDTO) throws Exception {
        return procesadorDAO.create(procesadorDTO);
    }

    public List<ProcesadorDTO> readAll() throws Exception {
        return procesadorDAO.readAll();
    }

    public ProcesadorDTO readBy(int id) throws Exception {
        return procesadorDAO.readBy(id);
    }

    public boolean update(ProcesadorDTO procesadorDTO) throws Exception {
        return procesadorDAO.update(procesadorDTO);
    }

    public boolean delete(int id) throws Exception {
        return procesadorDAO.delete(id);
    }
}

