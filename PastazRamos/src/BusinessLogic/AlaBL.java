package BusinessLogic;

import java.util.List;

import DataAccess.AlaDAO;
import DataAccess.DTO.AlaDTO;

public class AlaBL {
    private AlaDAO alaDAO;

    public AlaBL() {
        this.alaDAO = new AlaDAO();
    }

    public boolean create(AlaDTO alaDTO) throws Exception {
        return alaDAO.create(alaDTO);
    }

    public List<AlaDTO> readAll() throws Exception {
        return alaDAO.readAll();
    }

    public AlaDTO readBy(int id) throws Exception {
        return alaDAO.readBy(id);
    }

    public boolean update(AlaDTO alaDTO) throws Exception {
        return alaDAO.update(alaDTO);
    }

    public boolean delete(int id) throws Exception {
        return alaDAO.delete(id);
    }
}
