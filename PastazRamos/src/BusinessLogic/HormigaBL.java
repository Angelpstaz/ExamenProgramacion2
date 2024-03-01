package BusinessLogic;

import java.util.List;

import DataAccess.HormigaDAO;
import DataAccess.DTO.HormigaDTO;

public class HormigaBL {
    private HormigaDAO hormigaDAO;

    public HormigaBL() {
        this.hormigaDAO = new HormigaDAO();
    }

    public boolean create(HormigaDTO hormigaDTO) throws Exception {
        return hormigaDAO.create(hormigaDTO);
    }

    public List<HormigaDTO> readAll() throws Exception {
        return hormigaDAO.readAll();
    }

    public HormigaDTO readBy(int id) throws Exception {
        return hormigaDAO.readBy(id);
    }

    public boolean update(HormigaDTO hormigaDTO) throws Exception {
        return hormigaDAO.update(hormigaDTO);
    }

    public boolean delete(int id) throws Exception {
        return hormigaDAO.delete(id);
    }

    public HormigaDAO getHormigaDAO() {
        return hormigaDAO;
    }

    public void setHormigaDAO(HormigaDAO hormigaDAO) {
        this.hormigaDAO = hormigaDAO;
    }
}
