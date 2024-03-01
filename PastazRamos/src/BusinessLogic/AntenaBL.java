package BusinessLogic;

import java.util.List;

import DataAccess.AntenaDAO;
import DataAccess.DTO.AntenaDTO;

public class AntenaBL {
    private AntenaDAO antenaDAO;

    public AntenaBL() {
        this.antenaDAO = new AntenaDAO();
    }

    public boolean create(AntenaDTO antenaDTO) throws Exception {
        return antenaDAO.create(antenaDTO);
    }

    public List<AntenaDTO> readAll() throws Exception {
        return antenaDAO.readAll();
    }

    public AntenaDTO readById(int id) throws Exception {
       return antenaDAO.readBy(id);
    }

    public boolean update(AntenaDTO antenaDTO) throws Exception {
        return antenaDAO.update(antenaDTO);
    }

    public boolean delete(int id) throws Exception {
        return antenaDAO.delete(id);
    }
}

