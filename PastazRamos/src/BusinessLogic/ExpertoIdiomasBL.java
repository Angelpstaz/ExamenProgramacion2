package BusinessLogic;

import java.util.List;
import DataAccess.ExpertoIdiomasDAO;
import DataAccess.DTO.ExpertoIdiomasDTO;

public class ExpertoIdiomasBL {
    private ExpertoIdiomasDAO expertoIdiomasDAO;

    public ExpertoIdiomasDAO getExpertoIdiomasDAO() {
        return expertoIdiomasDAO;
    }

    public void setExpertoIdiomasDAO(ExpertoIdiomasDAO expertoIdiomasDAO) {
        this.expertoIdiomasDAO = expertoIdiomasDAO;
    }

    public ExpertoIdiomasBL() {
        this.expertoIdiomasDAO = new ExpertoIdiomasDAO();
    }

    public boolean create(ExpertoIdiomasDTO expertoIdiomasDTO) throws Exception {
        return expertoIdiomasDAO.create(expertoIdiomasDTO);
    }

    public List<ExpertoIdiomasDTO> readAll() throws Exception {
        return expertoIdiomasDAO.readAll();
    }

    public ExpertoIdiomasDTO readBy(int id) throws Exception {
        return expertoIdiomasDAO.readBy(id);
    }

    public boolean update(ExpertoIdiomasDTO expertoIdiomasDTO) throws Exception {
        return expertoIdiomasDAO.update(expertoIdiomasDTO);
    }

    public boolean delete(int id) throws Exception {
        return expertoIdiomasDAO.delete(id);
    }

}
