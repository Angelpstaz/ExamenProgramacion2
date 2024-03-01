package BusinessLogic;

import java.util.List;

import DataAccess.PataDAO;
import DataAccess.DTO.PataDTO;

public class PataBL {
    private PataDAO pataDAO;

    public PataBL() {
        this.pataDAO = new PataDAO();
    }

    public boolean create(PataDTO pataDTO) throws Exception {
        return pataDAO.create(pataDTO);
    }

    public List<PataDTO> readAll() throws Exception {
        return pataDAO.readAll();
    }

    public PataDTO readBy(Integer id) throws Exception {
        return pataDAO.readBy(id);
    }

    public boolean update(PataDTO pataDTO) throws Exception {
        return pataDAO.update(pataDTO);
    }

    public boolean delete(Integer id) throws Exception {
        return pataDAO.delete(id);
    }
}
