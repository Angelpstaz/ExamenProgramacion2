package BusinessLogic;

import java.util.List;

import DataAccess.RadioDAO;
import DataAccess.DTO.RadioDTO;

public class RadioBL {
    private RadioDAO radioDAO;

    public RadioBL() {
        this.radioDAO = new RadioDAO();
    }

    public boolean create(RadioDTO radioDTO) throws Exception {
        return radioDAO.create(radioDTO);
    }

    public List<RadioDTO> readAll() throws Exception {
        return radioDAO.readAll();
    }

    public RadioDTO readBy(int id) throws Exception {
        return radioDAO.readBy(id);
    }

    public boolean update(RadioDTO radioDTO) throws Exception {
        return radioDAO.update(radioDTO);
    }

    public boolean delete(int id) throws Exception {
        return radioDAO.delete(id);
    }
}
