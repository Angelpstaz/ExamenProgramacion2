package BusinessLogic;

import java.util.List;

import DataAccess.CamaraDAO;
import DataAccess.DTO.CamaraDTO;

public class CamaraBL {
    private CamaraDAO camaraDAO;

    public CamaraBL() {
        this.camaraDAO = new CamaraDAO();
    }

    public boolean create(CamaraDTO camaraDTO) throws Exception {
        return camaraDAO.create(camaraDTO);
    }

    public List<CamaraDTO> readAll() throws Exception {
        return camaraDAO.readAll();
    }

    public CamaraDTO readBy(int id) throws Exception {
        return camaraDAO.readBy(id);
    }

    public boolean update(CamaraDTO camaraDTO) throws Exception {
        return camaraDAO.update(camaraDTO);
    }

    public boolean delete(int id) throws Exception {
        return camaraDAO.delete(id);
    }
}
