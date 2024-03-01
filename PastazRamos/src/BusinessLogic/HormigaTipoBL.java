package BusinessLogic;

import java.util.List;

import DataAccess.HormigaTipoDAO;
import DataAccess.DTO.HormigaTipoDTO;

public class HormigaTipoBL {
    private HormigaTipoDAO hormigaTipoDAO;

    public HormigaTipoBL() {
        this.hormigaTipoDAO = new HormigaTipoDAO();
    }

    public boolean create(HormigaTipoDTO hormigaTipoDTO) throws Exception {
        return hormigaTipoDAO.create(hormigaTipoDTO);
    }

    public List<HormigaTipoDTO> readAll() throws Exception {
        return hormigaTipoDAO.readAll();
    }

    public HormigaTipoDTO readBy(int id) throws Exception {
        return hormigaTipoDAO.readBy(id);
    }

    public boolean update(HormigaTipoDTO hormigaTipoDTO) throws Exception {
        return hormigaTipoDAO.update(hormigaTipoDTO);
    }

    public boolean delete(int id) throws Exception {
        return hormigaTipoDAO.delete(id);
    }
}
